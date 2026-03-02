package tn.cpg.internservice.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tn.cpg.internservice.dto.ActiveAnnouncementDto;
import tn.cpg.internservice.dto.RecentCandidatureDto;
import tn.cpg.internservice.dto.TechnologyStats;
import tn.cpg.internservice.dto.UpcomingInterviewDto;
import tn.cpg.internservice.model.Announcement;
import tn.cpg.internservice.model.DashboardStats;
import tn.cpg.internservice.model.Entretien;
import tn.cpg.internservice.model.Request;
import tn.cpg.internservice.repository.AnnouncementRepository;
import tn.cpg.internservice.repository.EntretienRepository;
import tn.cpg.internservice.repository.RequestRespository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DashboardService {
    private final AnnouncementRepository announcementRepository;
    private final EntretienRepository entretienRepository;
    private final RequestRespository demandeRepository;

    @Autowired
    public DashboardService(
            AnnouncementRepository announcementRepository,
            EntretienRepository entretienRepository,
            RequestRespository demandeRepository) {
        this.announcementRepository = announcementRepository;
        this.entretienRepository = entretienRepository;
        this.demandeRepository = demandeRepository;
    }

    public DashboardStats getDashboardStats() {
        LocalDate currentDate = LocalDate.now();
        LocalDateTime currentDateTime = LocalDateTime.now();

        DashboardStats stats = new DashboardStats();

        // Récupérer les candidatures actives
        stats.setActiveCandidatures(demandeRepository.countRecentCandidatures(
                currentDate.minusMonths(1)));

        // Récupérer les entretiens planifiés
        stats.setPlannedInterviews(entretienRepository.countEntretienBetweenDates(
                currentDateTime,
                currentDateTime.plusDays(30)));

        // Récupérer les annonces actives
        stats.setActiveAnnouncements(announcementRepository.countActiveAnnouncements(
                currentDate));

        // Calculer le taux de réponse
         calculateResponseRate(stats);

        // Récupérer les statistiques des technologies
        stats.setTechnologyStats(getTechnologyStats(currentDate));

        // Récupérer les candidatures récentes
        stats.setRecentCandidatures(getRecentCandidatures());

        // Récupérer les prochains entretiens
        stats.setUpcomingInterviews(getUpcomingInterviews(currentDateTime));

        // Récupérer les annonces actives
        stats.setActiveAnnouncementsList(getActiveAnnouncements(currentDate));

        return stats;
    }



    private void calculateResponseRate(DashboardStats stats) {
        List<Object[]> statusCounts = demandeRepository.countCandidaturesByStatus();
        long totalCandidatures = 0;
        long respondedCandidatures = 0;

        for (Object[] statusCount : statusCounts) {
            String status = (String) statusCount[0];
            Long count = (Long) statusCount[1];
            totalCandidatures += count;
            if (!status.equals("En attente")) {
                respondedCandidatures += count;
            }
        }

        double responseRate = totalCandidatures > 0
                ? (respondedCandidatures * 100.0) / totalCandidatures
                : 0.0;
        stats.setResponseRate(responseRate);
    }

    private List<TechnologyStats> getTechnologyStats(LocalDate currentDate) {
        List<String> technologies = announcementRepository.findAllActiveTechnologies(currentDate);
        return technologies.stream()
                .map(tech -> {
                    Long count = announcementRepository.countAnnouncementsByTechnology(tech, currentDate);
                    return new TechnologyStats(tech, count);
                })
                .collect(Collectors.toList());
    }


    private List<RecentCandidatureDto> getRecentCandidatures() {
        return demandeRepository.findRecentCandidatures(PageRequest.of(0, 5))
                .stream()
                .map(this::mapToRecentCandidatureDto)
                .collect(Collectors.toList());
    }


    private List<UpcomingInterviewDto> getUpcomingInterviews(LocalDateTime currentDateTime) {
        return entretienRepository.findUpcomingEntretiens(
                        currentDateTime,
                        PageRequest.of(0, 5))
                .stream()
                .map(this::mapToUpcomingInterviewDto)
                .collect(Collectors.toList());
    }

    private List<ActiveAnnouncementDto> getActiveAnnouncements(LocalDate currentDate) {
        return announcementRepository.findActiveAnnouncements(currentDate)
                .stream()
                .map(this::mapToActiveAnnouncementDto)
                .collect(Collectors.toList());
    }

    // Méthodes de mapping
    private RecentCandidatureDto mapToRecentCandidatureDto(Request demande) {
        return new RecentCandidatureDto(
                demande.getNom(),
                demande.getPrenom(),
                demande.getDateCreation(),
                demande.getAnnouncement().getTitle(),
                demande.getStatus()
        );
    }

    private UpcomingInterviewDto mapToUpcomingInterviewDto(Entretien entretien) {
        return new UpcomingInterviewDto(
                entretien.getRequest().getNom(),
                entretien.getRequest().getPrenom(),
                entretien.getDate(),
                entretien.getLieu(),
                entretien.getStatus()
        );
    }

    private ActiveAnnouncementDto mapToActiveAnnouncementDto(Announcement announcement) {
        return new ActiveAnnouncementDto(
                announcement.getTitle(),
                announcement.getEndDate(),
                // Vous devrez peut-être ajouter une méthode pour compter les candidatures
                countCandidaturesForAnnouncement(announcement),
                "Active"
        );
    }

    private Long countCandidaturesForAnnouncement(Announcement announcement) {
        // Implémentez la logique pour compter les candidatures pour une annonce
        return 0L; // À implémenter selon vos besoins
    }
}