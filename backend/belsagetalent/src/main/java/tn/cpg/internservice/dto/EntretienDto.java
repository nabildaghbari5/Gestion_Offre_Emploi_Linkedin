package tn.cpg.internservice.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.cpg.internservice.model.Request;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntretienDto {

    private Integer id;
    private LocalDateTime date;
    private String status;
    private String lieu ;
    private Request request;

}
