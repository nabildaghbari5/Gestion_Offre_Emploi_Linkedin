package tn.cpg.internservice.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ImageModel  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id ; 
	private String name ; 
	private String type ; 
	@Column(length=500000000)
	private byte[] picByte;
    private String  userId;
   
    
	public ImageModel(String name, String type, byte[] picByte ) {
		super();
		this.name = name;
		this.type = type;
		this.picByte = picByte; 
		
	}
	
	public ImageModel(String name, String type, byte[] picByte , String userId ) {
		super();
		this.name = name;  
		this.type = type;
		this.picByte = picByte;
		this.userId=userId ;   
		
	}
	
	
	
	
	
	

}
