package tn.cpg.internservice.dto;

import java.time.LocalDate;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;  

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnnouncementDto {
	   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int offerNumber;
    private LocalDate publicationDate;
    private LocalDate applicationDeadLine;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private String technologies;
    // Nouveau champ pour LinkedIn
    private boolean publishToLinkedIn;
    // ID de la publication LinkedIn une fois publiée
    private String linkedInPostId;

}
