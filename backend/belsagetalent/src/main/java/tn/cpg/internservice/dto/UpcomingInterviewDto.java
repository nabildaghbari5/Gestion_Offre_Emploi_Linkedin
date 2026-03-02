package tn.cpg.internservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpcomingInterviewDto {
    private String candidatNom;
    private String candidatPrenom;
    private LocalDateTime date;
    private String lieu;
    private String status;
}
