package com.wingbels.belssagecore.entities;

import com.wingbels.belssagecore.enumerations.Bcrelation;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wingbels.belssagecore.enumerations.Bcphonecountrycode;
import com.wingbels.belssagecore.enumerations.Bctypecontact;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Bccontacts {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idcontact;
	private Bctypecontact typecontact;
	private Bcphonecountrycode countrycodecontact;
	private String valuecontact;
	private Bcrelation relation;
	private String owneremergency;
	private String valueemergencycontact;
	@ManyToOne
	@JsonBackReference
	private Bcemployees employee;

	public Long getIdcontact() {
		return idcontact;
	}

	public void setIdcontact(Long idcontact) {
		this.idcontact = idcontact;
	}

	public Bctypecontact getTypecontact() {
		return typecontact;
	}

	public void setTypecontact(Bctypecontact typecontact) {
		this.typecontact = typecontact;
	}

	public Bcphonecountrycode getCountrycodecontact() {
		return countrycodecontact;
	}

	public void setCountrycodecontact(Bcphonecountrycode countrycodecontact) {
		this.countrycodecontact = countrycodecontact;
	}

	public String getValuecontact() {
		return valuecontact;
	}

	public void setValuecontact(String valuecontact) {
		this.valuecontact = valuecontact;
	}

	public Bcrelation getRelation() {
		return relation;
	}

	public void setRelation(Bcrelation relation) {
		this.relation = relation;
	}

	public String getOwneremergency() {
		return owneremergency;
	}

	public void setOwneremergency(String owneremergency) {
		this.owneremergency = owneremergency;
	}

	public String getValueemergencycontact() {
		return valueemergencycontact;
	}

	public void setValueemergencycontact(String valueemergencycontact) {
		this.valueemergencycontact = valueemergencycontact;
	}
	
	public Bcemployees getEmployee() {
		return employee;
	}
	
	public void setEmployee(Bcemployees employee) {
		this.employee = employee;
	}

}