package com.wingbels.belssagecore.entities;

import jakarta.persistence.*;

@Entity
public class Bcaddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idadresse;
	private String buildingnumberaddress;
	private String streetnameaddress;
	@ManyToOne
	private Bccities cityaddress;
	@ManyToOne
	private Bczipcode zipcodeaddress;
	@ManyToOne
	private Bccountries countryaddress;
	public Long getIdadresse() {
		return idadresse;
	}
	public void setIdadresse(Long idadresse) {
		this.idadresse = idadresse;
	}
	public String getBuildingnumberaddress() {
		return buildingnumberaddress;
	}
	public void setBuildingnumberaddress(String buildingnumberaddress) {
		this.buildingnumberaddress = buildingnumberaddress;
	}
	public String getStreetnameaddress() {
		return streetnameaddress;
	}
	public void setStreetnameaddress(String streetnameaddress) {
		this.streetnameaddress = streetnameaddress;
	}
	public Bccities getCityaddress() {
		return cityaddress;
	}
	public void setCityaddress(Bccities cityaddress) {
		this.cityaddress = cityaddress;
	}
	public Bczipcode getZipcodeaddress() {
		return zipcodeaddress;
	}
	public void setZipcodeaddress(Bczipcode zipcodeaddress) {
		this.zipcodeaddress = zipcodeaddress;
	}
	public Bccountries getCountryaddress() {
		return countryaddress;
	}
	public void setCountryaddress(Bccountries countryaddress) {
		this.countryaddress = countryaddress;
	}
}
