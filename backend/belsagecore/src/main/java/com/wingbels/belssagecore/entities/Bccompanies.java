package com.wingbels.belssagecore.entities;

import com.wingbels.belssagecore.enumerations.Bctypecompanies;

import jakarta.persistence.*;

@Entity
public class Bccompanies {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idcompany;
	private String fiscalcodecompany;
	private String namecompany;
	private Bctypecompanies typecompany;
	private boolean groupcompnay;
	@OneToOne(cascade = CascadeType.ALL)
	private Bcaddress addresscompany;
	@ManyToOne
	private Bccompanies associatedgroup;
	
	public Long getIdcompany() {
		return idcompany;
	}
	public void setIdcompany(Long idcompany) {
		this.idcompany = idcompany;
	}
	public String getFiscalcodecompany() {
		return fiscalcodecompany;
	}
	public void setFiscalcodecompany(String fiscalcodecompany) {
		this.fiscalcodecompany = fiscalcodecompany;
	}
	public String getNamecompany() {
		return namecompany;
	}
	public void setNamecompany(String namecompany) {
		this.namecompany = namecompany;
	}
	public Bctypecompanies getTypecompany() {
		return typecompany;
	}
	public void setTypecompany(Bctypecompanies typecompany) {
		this.typecompany = typecompany;
	}
	public boolean isGroupcompnay() {
		return groupcompnay;
	}
	public void setGroupcompnay(boolean groupcompnay) {
		this.groupcompnay = groupcompnay;
	}
	public Bcaddress getAddresscompany() {
		return addresscompany;
	}
	public void setAddresscompany(Bcaddress addresscompany) {
		this.addresscompany = addresscompany;
	}
	public Bccompanies getAssociatedgroup() {
		return associatedgroup;
	}
	public void setAssociatedgroup(Bccompanies associatedgroup) {
		this.associatedgroup = associatedgroup;
	}
}
