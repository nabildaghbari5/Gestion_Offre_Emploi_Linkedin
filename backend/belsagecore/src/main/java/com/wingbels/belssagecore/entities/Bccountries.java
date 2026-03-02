package com.wingbels.belssagecore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bccountries {
	@Id
	public String codecountry;
	public String countrydescription;
	public String getCodecountry() {
		return codecountry;
	}
	public void setCodecountry(String codecountry) {
		this.codecountry = codecountry;
	}
	public String getCountrydescription() {
		return countrydescription;
	}
	public void setCountrydescription(String countrydescription) {
		this.countrydescription = countrydescription;
	}
}
