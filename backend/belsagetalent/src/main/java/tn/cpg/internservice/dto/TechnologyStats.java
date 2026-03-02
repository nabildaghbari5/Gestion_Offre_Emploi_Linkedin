package tn.cpg.internservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyStats {
    private String technology;
    private Long count;
    private Double percentage;

    public TechnologyStats(String technology, Long count) {
        this.technology = technology;
        this.count = count;
    }
}
