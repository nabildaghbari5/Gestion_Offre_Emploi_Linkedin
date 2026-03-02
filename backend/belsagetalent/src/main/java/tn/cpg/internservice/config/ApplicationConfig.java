package tn.cpg.internservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.RequiredArgsConstructor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpHeaders.ORIGIN;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.web.bind.annotation.RequestMethod.PATCH;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import tn.cpg.internservice.impl.LinkedInService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.stream.Collectors;
@Configuration
@RequiredArgsConstructor
@Slf4j
public class ApplicationConfig {
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();

		// Ajouter un intercepteur pour logger les requêtes et réponses
		restTemplate.setInterceptors(Collections.singletonList((request, body, execution) -> {
			log.debug("Request URI: {}", request.getURI());
			log.debug("Request Method: {}", request.getMethod());
			log.debug("Request Headers: {}", request.getHeaders());
			log.debug("Request Body: {}", new String(body));

			ClientHttpResponse response = execution.execute(request, body);

			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getBody()));
			String responseBody = reader.lines().collect(Collectors.joining("\n"));
			log.debug("Response Status: {}", response.getStatusCode());
			log.debug("Response Headers: {}", response.getHeaders());
			log.debug("Response Body: {}", responseBody);

			return response;
		}));

		// Configurer un gestionnaire d'erreurs personnalisé
		restTemplate.setErrorHandler(new ResponseErrorHandler() {
			@Override
			public boolean hasError(ClientHttpResponse response) throws IOException {
				return response.getStatusCode().is4xxClientError() ||
						response.getStatusCode().is5xxServerError();
			}

			@Override
			public void handleError(ClientHttpResponse response) throws IOException {
				if (response.getStatusCode().is4xxClientError()) {
					BufferedReader reader = new BufferedReader(new InputStreamReader(response.getBody()));
					String responseBody = reader.lines().collect(Collectors.joining("\n"));
					throw new LinkedInService.LinkedInPublicationException(
							"Erreur LinkedIn " + response.getStatusCode() + ": " + responseBody
					);
				}
			}
		});

		return restTemplate;
	}


	@Bean
		  public CorsFilter corsFilter() {
			final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			final CorsConfiguration config = new CorsConfiguration();
			config.setAllowCredentials(true);
			config.setAllowedOrigins(Collections.singletonList("http://localhost:4850"));
			config.setAllowedHeaders(Arrays.asList(
					ORIGIN,
					CONTENT_TYPE,
					ACCEPT,
					AUTHORIZATION
			));
			config.setAllowedMethods(Arrays.asList(
					GET.name(),
					POST.name(),
					DELETE.name(),
					PUT.name(),
					PATCH.name()
			));
			source.registerCorsConfiguration("/**", config);
			return new CorsFilter(source);

		  }

}
