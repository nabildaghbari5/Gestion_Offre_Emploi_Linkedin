package tn.cpg.internservice.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Request {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private LocalDate  dateCreation;  
    private String nom;
    private String prenom ; 
    private String cin ; 
    private String adresse ; 
    private String status ;
    //@Column(columnDefinition = "TEXT")
    private String candidateId;

    @JsonIgnore
      @ManyToMany(fetch=FetchType.EAGER , cascade=CascadeType.ALL) 
	   @JoinTable(name="demande_document",
	  
	  			joinColumns= {
	  					
	  					@JoinColumn(name="demande_id")
	  			}, 
	  			inverseJoinColumns= {
	  					@JoinColumn(name="document_id")  
	  			}
	  
			  )
	    private Set<ImageModel> document ;

    
    @ManyToOne
	@JoinColumn(name = "announcement_id")
	private Announcement announcement; 

}



