package com.wingbels.belssagecore.entities;

import jakarta.persistence.*;

@Entity
public class Bczipcode {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idzipcode;
	private String locationzipcode;
	private String codezipcode;
	@OneToOne
	private Bccities cityzipcode;
	@ManyToOne
	private Bccountries countryzipcode;

	public Long getIdzipcode() {
		return idzipcode;
	}

	public void setIdzipcode(Long idzipcode) {
		this.idzipcode = idzipcode;
	}

	public String getLocationzipcode() {
		return locationzipcode;
	}

	public void setLocationzipcode(String locationzipcode) {
		this.locationzipcode = locationzipcode;
	}

	public String getCodezipcode() {
		return codezipcode;
	}

	public void setCodezipcode(String codezipcode) {
		this.codezipcode = codezipcode;
	}

	public Bccities getCityzipcode() {
		return cityzipcode;
	}

	public void setCityzipcode(Bccities cityzipcode) {
		this.cityzipcode = cityzipcode;
	}

	public Bccountries getCountryzipcode() {
		return countryzipcode;
	}

	public void setCountryzipcode(Bccountries countryzipcode) {
		this.countryzipcode = countryzipcode;
	}
}
