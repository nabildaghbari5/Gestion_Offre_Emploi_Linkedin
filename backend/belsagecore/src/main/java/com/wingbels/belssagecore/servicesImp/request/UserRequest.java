package com.wingbels.belssagecore.servicesImp.request;

import java.util.Set;

import com.wingbels.belssagecore.entities.Bcemployees;

public class UserRequest {
	private String uidusers;
	private String username;
	private String nameusers;
	private String surnameusers;
	private String password;
	private Bcemployees associatedemployeeuser;
	private String roles;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSurnameusers() {
		return surnameusers;
	}
	public void setSurnameusers(String surnameusers) {
		this.surnameusers = surnameusers;
	}
	public Bcemployees getAssociatedemployeeuser() {
		return associatedemployeeuser;
	}
	public void setAssociatedemployeeuser(Bcemployees associatedemployeeuser) {
		this.associatedemployeeuser = associatedemployeeuser;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
}
