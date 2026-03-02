package com.wingbels.belssagecore.entities;

import java.time.LocalDate;
import java.util.Set;

import com.wingbels.belssagecore.enumerations.Bcroleuser;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Bcusers {
	@Id
	private String uidusers;
	private String username;
	private String nameusers;
	private String surnameusers;
	private boolean enabled;
	private LocalDate datetimecreation;
	private LocalDate datetimelastupdate;
	@OneToOne
	private Bcemployees associatedemployeeuser;
	private Bcroleuser roles;
    @ManyToOne
    private Bcprofiles profiles;
	
    public Bcusers() {
    }

	public Bcusers(String uidusers, String username, String nameusers, String surnameusers, boolean enabled,
			LocalDate datetimecreation, LocalDate datetimelastupdate, Bcemployees associatedemployeeuser,
			Bcroleuser roles) {
		this.uidusers = uidusers;
		this.username = username;
		this.nameusers = nameusers;
		this.surnameusers = surnameusers;
		this.enabled = enabled;
		this.datetimecreation = datetimecreation;
		this.datetimelastupdate = datetimelastupdate;
		this.associatedemployeeuser = associatedemployeeuser;
		this.roles = roles;
	}

	public String getUidusers() {
		return uidusers;
	}

	public void setUidusers(String uidusers) {
		this.uidusers = uidusers;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNameusers() {
		return nameusers;
	}

	public void setNameusers(String nameusers) {
		this.nameusers = nameusers;
	}

	public String getSurnameusers() {
		return surnameusers;
	}

	public void setSurnameusers(String surnameusers) {
		this.surnameusers = surnameusers;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public LocalDate getDatetimecreation() {
		return datetimecreation;
	}

	public void setDatetimecreation(LocalDate datetimecreation) {
		this.datetimecreation = datetimecreation;
	}

	public LocalDate getDatetimelastupdate() {
		return datetimelastupdate;
	}

	public void setDatetimelastupdate(LocalDate datetimelastupdate) {
		this.datetimelastupdate = datetimelastupdate;
	}

	public Bcemployees getAssociatedemployeeuser() {
		return associatedemployeeuser;
	}

	public void setAssociatedemployeeuser(Bcemployees associatedemployeeuser) {
		this.associatedemployeeuser = associatedemployeeuser;
	}
	
	public Bcroleuser getRoles() {
		return roles;
	}
	
	public void setRoles(Bcroleuser roles) {
		this.roles = roles;
	}
	
	public Bcprofiles getProfiles() {
		return profiles;
	}
	public void setProfiles(Bcprofiles profiles) {
		this.profiles = profiles;
	}

}
