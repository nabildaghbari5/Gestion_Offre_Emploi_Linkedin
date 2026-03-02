package tn.cpg.internservice.dto;

import lombok.Data;
import java.util.List;

@Data
public class TestEvaluationDTO {
    private String candidateId;
    private Integer requestId;
    private List<AnswerDTO> answers;
}