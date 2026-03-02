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
public class ActiveAnnouncementDto {
    private String title;
    private LocalDate dateLimite;
    private Long nombreCandidatures;
    private String status;

}
