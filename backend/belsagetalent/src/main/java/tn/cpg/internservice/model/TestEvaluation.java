package tn.cpg.internservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

// TestEvaluation.java
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String candidateId; // Lié au candidateId de Request

    @ManyToOne
    @JoinColumn(name = "request_id")
    private Request request;

    private LocalDateTime submissionDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluation")
    private List<Answer> answers;
}