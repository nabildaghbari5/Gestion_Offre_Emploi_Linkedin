package com.wingbels.belssagecore.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Bcprofiles {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idprofile;
	private String nameprofile;
	@ManyToMany
	private Set<Bcfunctionality> functionalities;

	public Long getIdprofile() {
		return idprofile;
	}

	public void setIdprofile(Long idprofile) {
		this.idprofile = idprofile;
	}

	public String getNameprofile() {
		return nameprofile;
	}

	public void setNameprofile(String nameprofile) {
		this.nameprofile = nameprofile;
	}

	public Set<Bcfunctionality> getFunctionalities() {
		return functionalities;
	}

	public void setFunctionalities(Set<Bcfunctionality> functionalities) {
		this.functionalities = functionalities;
	}
}
