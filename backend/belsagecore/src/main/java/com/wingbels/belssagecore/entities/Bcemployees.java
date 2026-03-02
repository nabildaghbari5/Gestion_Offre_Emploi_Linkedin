package com.wingbels.belssagecore.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wingbels.belssagecore.enumerations.Bcgenderemployee;
import com.wingbels.belssagecore.enumerations.Bcroleuser;

import jakarta.persistence.*;

@Entity
public class Bcemployees {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idemployee;
	private String firstnameemployee;
	private String lastnameemployee;
	private LocalDate birthdateemployee;
	private Bcgenderemployee genderemployee;
	private String currentpositionemployee;
	@ManyToOne
	private Bcemployees currentmanageremployee;
	@ManyToOne
	private Bcdepartments currentdepartmentemployee;
	@ManyToOne(cascade = CascadeType.ALL)
	private Bcaddress addressemployee;
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JsonManagedReference
	private Set<Bccontacts> contactemployee;

	public Set<Bccontacts> getContactemployee() {
		return contactemployee;
	}

	public void setContactemployee(Set<Bccontacts> contactemployee) {
        this.contactemployee = contactemployee;
        if (contactemployee != null) {
            for (Bccontacts contact : contactemployee) {
                contact.setEmployee(this);
            }
        }
	}

	public Long getIdemployee() {
		return idemployee;
	}

	public void setIdemployee(Long idemployee) {
		this.idemployee = idemployee;
	}

	public String getFirstnameemployee() {
		return firstnameemployee;
	}

	public void setFirstnameemployee(String firstnameemployee) {
		this.firstnameemployee = firstnameemployee;
	}

	public String getLastnameemployee() {
		return lastnameemployee;
	}

	public void setLastnameemployee(String lastnameemployee) {
		this.lastnameemployee = lastnameemployee;
	}

	public LocalDate getBirthdateemployee() {
		return birthdateemployee;
	}

	public void setBirthdateemployee(LocalDate birthdateemployee) {
		this.birthdateemployee = birthdateemployee;
	}

	public Bcgenderemployee getGenderemployee() {
		return genderemployee;
	}

	public void setGenderemployee(Bcgenderemployee genderemployee) {
		this.genderemployee = genderemployee;
	}

	public String getCurrentpositionemployee() {
		return currentpositionemployee;
	}

	public void setCurrentpositionemployee(String currentpositionemployee) {
		this.currentpositionemployee = currentpositionemployee;
	}

	public Bcemployees getCurrentmanageremployee() {
		return currentmanageremployee;
	}

	public void setCurrentmanageremployee(Bcemployees currentmanageremployee) {
		this.currentmanageremployee = currentmanageremployee;
	}

	public Bcdepartments getCurrentdepartmentemployee() {
		return currentdepartmentemployee;
	}

	public void setCurrentdepartmentemployee(Bcdepartments currentdepartmentemployee) {
		this.currentdepartmentemployee = currentdepartmentemployee;
	}
	
	public Bcaddress getAddressemployee() {
		return addressemployee;
	}

	public void setAddressemployee(Bcaddress addressemployee) {
		this.addressemployee = addressemployee;
	}

}
