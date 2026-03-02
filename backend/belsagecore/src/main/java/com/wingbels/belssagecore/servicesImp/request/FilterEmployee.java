package com.wingbels.belssagecore.servicesImp.request;

import com.wingbels.belssagecore.entities.Bcdepartments;
import com.wingbels.belssagecore.entities.Bcemployees;

public class FilterEmployee {
    private String firstnameemployee;
    private String lastnameemployee;
    private String genderemployee;
    private String currentpositionemployee;
    private Bcemployees currentmanageremployee;
    private Bcdepartments currentdepartmentemployee;
    private String telephone;
    private String email;
    
	public String getFirstnameemployee() {
		return firstnameemployee;
	}
	public void setFirstnameemployee(String firstnameemployee) {
		this.firstnameemployee = firstnameemployee;
	}
	public String getLastnameemployee() {
		return lastnameemployee;
	}
	public void setLastnameemployee(String lastnameemployee) {
		this.lastnameemployee = lastnameemployee;
	}
	public String getGenderemployee() {
		return genderemployee;
	}
	public void setGenderemployee(String genderemployee) {
		this.genderemployee = genderemployee;
	}
	public String getCurrentpositionemployee() {
		return currentpositionemployee;
	}
	public void setCurrentpositionemployee(String currentpositionemployee) {
		this.currentpositionemployee = currentpositionemployee;
	}
	public Bcemployees getCurrentmanageremployee() {
		return currentmanageremployee;
	}
	public void setCurrentmanageremployee(Bcemployees currentmanageremployee) {
		this.currentmanageremployee = currentmanageremployee;
	}
	public Bcdepartments getCurrentdepartmentemployee() {
		return currentdepartmentemployee;
	}
	public void setCurrentdepartmentemployee(Bcdepartments currentdepartmentemployee) {
		this.currentdepartmentemployee = currentdepartmentemployee;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
}
