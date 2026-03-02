package tn.cpg.internservice.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.cpg.internservice.model.Entretien;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EntretienRepository extends JpaRepository<Entretien,Integer > {

    // Compter les entretiens entre deux dates
    @Query("SELECT COUNT(e) FROM Entretien e WHERE e.date >= :startDate AND e.date <= :endDate")
    Long countEntretienBetweenDates(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    // Récupérer les entretiens à venir, triés par date ascendante, avec pagination
    @Query("SELECT e FROM Entretien e WHERE e.date >= :currentDate ORDER BY e.date ASC")
    List<Entretien> findUpcomingEntretiens(@Param("currentDate") LocalDateTime currentDate , Pageable pageable);

    // Compter le nombre d'entretiens par statut, avec une projection
    @Query("SELECT e.status AS status, COUNT(e) AS count FROM Entretien e GROUP BY e.status")
    List<EntretienStatusCount> countEntretienByStatus();

    // Interface de projection pour le comptage des entretiens par statut
    interface EntretienStatusCount {
        String getStatus();
        Long getCount();
    }

}
