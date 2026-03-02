package tn.cpg.internservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.cpg.internservice.model.Announcement;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AnnouncementRepository  extends JpaRepository<Announcement, Integer> {

    @Query("SELECT COUNT(a) FROM Announcement a WHERE a.endDate >= :currentDate")
    Long countActiveAnnouncements(LocalDate currentDate);

    @Query("SELECT a FROM Announcement a WHERE a.endDate >= :currentDate")
    List<Announcement> findActiveAnnouncements(LocalDate currentDate);

    @Query("SELECT DISTINCT a.technologies FROM Announcement a WHERE a.endDate >= :currentDate")
    List<String> findAllActiveTechnologies(LocalDate currentDate);

    @Query("SELECT COUNT(a) FROM Announcement a WHERE a.technologies LIKE %:technology% AND a.endDate >= :currentDate")
    Long countAnnouncementsByTechnology(String technology, LocalDate currentDate);

}  
