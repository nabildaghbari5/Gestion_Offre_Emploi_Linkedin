package com.wingbels.belssagecore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bcproperties {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idproperty;
	private String nameproperty;
	private String possiblevaleproperty;
	private String valueproperty;
	private boolean enabledproperty;

	public Long getIdproperty() {
		return idproperty;
	}

	public void setIdproperty(Long idproperty) {
		this.idproperty = idproperty;
	}

	public String getNameproperty() {
		return nameproperty;
	}

	public void setNameproperty(String nameproperty) {
		this.nameproperty = nameproperty;
	}

	public String getPossiblevaleproperty() {
		return possiblevaleproperty;
	}

	public void setPossiblevaleproperty(String possiblevaleproperty) {
		this.possiblevaleproperty = possiblevaleproperty;
	}

	public String getValueproperty() {
		return valueproperty;
	}

	public void setValueproperty(String valueproperty) {
		this.valueproperty = valueproperty;
	}

	public boolean isEnabledproperty() {
		return enabledproperty;
	}

	public void setEnabledproperty(boolean enabledproperty) {
		this.enabledproperty = enabledproperty;
	}
}
