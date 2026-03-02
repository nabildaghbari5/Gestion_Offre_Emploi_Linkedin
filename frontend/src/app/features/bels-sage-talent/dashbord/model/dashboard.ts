export interface DashboardStats {
    activeCandidatures: number;
    plannedInterviews: number;
    activeAnnouncements: number;
    responseRate: number;
    technologyStats: TechnologyStats[];
    recentCandidatures: RecentCandidatureDto[];
    upcomingInterviews: UpcomingInterviewDto[];
    activeAnnouncementsList: ActiveAnnouncementDto[];
}

export interface TechnologyStats {
    technology: string;
    count: number;
    percentage: number;
}

export interface RecentCandidatureDto {
    nom: string;
    prenom: string;
    dateCreation: string;
    posteTitle: string;
    status: string;
}

export interface UpcomingInterviewDto {
    candidatNom: string;
    candidatPrenom: string;
    date: string;
    lieu: string;
    status: string;
}

export interface ActiveAnnouncementDto {
    title: string;
    dateLimite: string;
    nombreCandidatures: number;
    status: string;
}