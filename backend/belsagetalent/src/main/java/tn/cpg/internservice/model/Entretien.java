package tn.cpg.internservice.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Entretien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime date; // Date et heure de l'entretien
    @Column(nullable = false)
    private String status; // Statut de l'entretien (planifié, terminé, etc.)
    private String lieu ;
    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private Request request; // Référence à la demande associée

}
