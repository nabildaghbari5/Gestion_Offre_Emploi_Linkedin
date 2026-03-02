package com.wingbels.belssagecore.entities;

import jakarta.persistence.*;

@Entity
public class Bccities {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idcity;
	private String namecity;
	@ManyToOne
	private Bccountries countrycity;
	public Long getIdcity() {
		return idcity;
	}
	public void setIdcity(Long idcity) {
		this.idcity = idcity;
	}
	public String getNamecity() {
		return namecity;
	}
	public void setNamecity(String namecity) {
		this.namecity = namecity;
	}
	public Bccountries getCountrycity() {
		return countrycity;
	}
	public void setCountrycity(Bccountries countrycity) {
		this.countrycity = countrycity;
	}

}
