package tn.cpg.internservice.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Announcement {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int offerNumber;
    private LocalDate publicationDate;
    private LocalDate applicationDeadLine;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String technologies;

    // Nouveau champ pour LinkedIn
    private boolean publishToLinkedIn;

    // ID de la publication LinkedIn une fois publiée
    private String linkedInPostId;

}
