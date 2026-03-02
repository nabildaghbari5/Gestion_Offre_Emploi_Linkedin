package tn.cpg.internservice.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import tn.cpg.internservice.model.Announcement;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
@Slf4j
public class LinkedInService {

    @Value("${linkedin.api.access-token}")
    private String linkedInAccessToken;

    @Value("${linkedin.sub}")
    private String sub;

    private static final String LINKEDIN_API_URL = "https://api.linkedin.com/v2/ugcPosts";
    private static final String PROTOCOL_VERSION = "2.0.0";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public LinkedInService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public String publishJobToLinkedIn(Announcement announcement) {
        validateAnnouncement(announcement);
        log.info("Début de la publication sur LinkedIn pour l'annonce: {}", announcement.getTitle());
        log.debug("Contenu complet de l'annonce: {}", announcement);

        try {
            // Génération du contenu
            String text = createJobDescription(announcement);
            log.debug("Description générée: {}", text);

            // Construction du corps de la requête
            Map<String, Object> requestBody = buildRequestBody(text);
            log.debug("Corps de la requête: {}", objectMapper.writeValueAsString(requestBody));

            // Configuration et envoi de la requête
            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, buildHeaders());

            ResponseEntity<String> response = restTemplate.exchange(
                    LINKEDIN_API_URL,
                    HttpMethod.POST,
                    requestEntity,
                    String.class
            );

            // Traitement de la réponse
            return processResponse(response);

        } catch (HttpClientErrorException e) {
            String responseBody = e.getResponseBodyAsString();
            log.error("Erreur HTTP LinkedIn: Status={}, Body={}", e.getStatusCode(), responseBody);
            throw new LinkedInPublicationException("Erreur LinkedIn: " + e.getStatusCode() + " - " + responseBody);
        } catch (Exception e) {
            log.error("Erreur inattendue lors de la publication sur LinkedIn", e);
            throw new LinkedInPublicationException("Erreur de publication: " + e.getMessage());
        }
    }

    private void validateAnnouncement(Announcement announcement) {
        if (announcement == null) {
            throw new IllegalArgumentException("L'annonce ne peut pas être null");
        }
        if (announcement.getTitle() == null || announcement.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Le titre de l'annonce est requis");
        }
        if (announcement.getDescription() == null || announcement.getDescription().trim().isEmpty()) {
            throw new IllegalArgumentException("La description de l'annonce est requise");
        }
        if (announcement.getPublicationDate() == null) {
            throw new IllegalArgumentException("La date de publication est requise");
        }
        if (announcement.getEndDate() == null) {
            throw new IllegalArgumentException("La date de fin est requise");
        }
    }

    private HttpHeaders buildHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(linkedInAccessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Restli-Protocol-Version", PROTOCOL_VERSION);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return headers;
    }

    private Map<String, Object> buildRequestBody(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Le texte du post ne peut pas être vide");
        }
        if (sub == null || sub.trim().isEmpty()) {
            throw new IllegalArgumentException("L'identifiant LinkedIn (sub) n'est pas configuré");
        }

        Map<String, Object> requestBody = new LinkedHashMap<>();
        requestBody.put("author", "urn:li:person:" + sub);
        requestBody.put("lifecycleState", "PUBLISHED");

        // Construction du contenu spécifique
        Map<String, Object> specificContent = new LinkedHashMap<>();
        Map<String, Object> shareContent = new LinkedHashMap<>();
        Map<String, Object> shareCommentary = new LinkedHashMap<>();
        shareCommentary.put("text", text);

        shareContent.put("shareCommentary", shareCommentary);
        shareContent.put("shareMediaCategory", "NONE");
        specificContent.put("com.linkedin.ugc.ShareContent", shareContent);
        requestBody.put("specificContent", specificContent);

        // Configuration de la visibilité
        Map<String, String> visibility = new LinkedHashMap<>();
        visibility.put("com.linkedin.ugc.MemberNetworkVisibility", "PUBLIC");
        requestBody.put("visibility", visibility);

        return requestBody;
    }

    private String createJobDescription(Announcement announcement) {
        return String.format(
                """
                🔍 Nouvelle opportunité : %s
    
                📝 Description :
                %s
    
                💻 Technologies requises :
                %s
    
                📅 Date de début : %s
                📅 Date limite de candidature : %s
    
                🔎 Postulez maintenant et rejoignez notre équipe !
                #Recrutement #Opportunité #Stage
                """,
                announcement.getTitle(),
                announcement.getDescription(),
                announcement.getTechnologies() != null ? announcement.getTechnologies() : "Non spécifiées",
                announcement.getPublicationDate().format(DateTimeFormatter.ISO_DATE),
                announcement.getEndDate().format(DateTimeFormatter.ISO_DATE)
        );
    }

    private String processResponse(ResponseEntity<String> response) throws Exception {
        if (response.getBody() == null) {
          //  throw new LinkedInPublicationException("Réponse vide de LinkedIn");
        }

        Map<String, Object> responseBody = objectMapper.readValue(
                response.getBody(),
                new TypeReference<Map<String, Object>>() {}
        );

        if (responseBody.get("id") == null) {
            throw new LinkedInPublicationException("ID de publication manquant dans la réponse");
        }

        String postId = responseBody.get("id").toString();
        log.info("Publication LinkedIn réussie avec l'ID: {}", postId);
        return postId;
    }

    public static class LinkedInPublicationException extends RuntimeException {
        public LinkedInPublicationException(String message) {
            super(message);
        }
    }
}