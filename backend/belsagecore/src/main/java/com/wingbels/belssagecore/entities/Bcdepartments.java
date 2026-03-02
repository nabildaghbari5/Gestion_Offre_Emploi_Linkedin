package com.wingbels.belssagecore.entities;

import jakarta.persistence.*;

@Entity
public class Bcdepartments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long iddepartment;
	private String namedepartment;
	@Column(nullable=false,unique=true)
	private long codedept;
	@OneToOne(cascade = CascadeType.ALL)
	private Bcaddress addressedepartment;
	@OneToOne
	private Bcemployees managerdepartement;
	@ManyToOne
	private Bccompanies associatedcompany;

	public Long getIddepartment() {
		return iddepartment;
	}
	public void setIddepartment(Long iddepartment) {
		this.iddepartment = iddepartment;
	}
	public String getNamedepartment() {
		return namedepartment;
	}
	public void setNamedepartment(String namedepartment) {
		this.namedepartment = namedepartment;
	}
	public Bcaddress getAddressedepartment() {
		return addressedepartment;
	}
	public void setAddressedepartment(Bcaddress addressedepartment) {
		this.addressedepartment = addressedepartment;
	}
	public Bcemployees getManagerdepartement() {
		return managerdepartement;
	}
	public void setManagerdepartement(Bcemployees managerdepartement) {
		this.managerdepartement = managerdepartement;
	}
	public long getCodedept() {
		return codedept;
	}
	public void setCodedept(long codedept) {
		this.codedept = codedept;
	}
	public Bccompanies getAssociatedcompany() {
		return associatedcompany;
	}
	public void setAssociatedcompany(Bccompanies associatedcompany) {
		this.associatedcompany = associatedcompany;
	}

}
