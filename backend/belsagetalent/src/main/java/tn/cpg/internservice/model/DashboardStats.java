package tn.cpg.internservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.cpg.internservice.dto.ActiveAnnouncementDto;
import tn.cpg.internservice.dto.RecentCandidatureDto;
import tn.cpg.internservice.dto.TechnologyStats;
import tn.cpg.internservice.dto.UpcomingInterviewDto;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DashboardStats {
    private Long activeCandidatures;
    private Long plannedInterviews;
    private Long activeAnnouncements;
    private Double responseRate;
    private List<TechnologyStats> technologyStats;
    private List<RecentCandidatureDto> recentCandidatures;
    private List<UpcomingInterviewDto> upcomingInterviews;
    private List<ActiveAnnouncementDto> activeAnnouncementsList;
}

