package tn.cpg.internservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecentCandidatureDto {
    private String nom;
    private String prenom;
    private LocalDate dateCreation;
    private String posteTitle;
    private String status;

}
