package com.wingbels.belssagecore.servicesImp.response;

import java.util.List;

import com.wingbels.belssagecore.entities.Bccareers;
import com.wingbels.belssagecore.entities.Bcdocuments;
import com.wingbels.belssagecore.entities.Bcemployees;
import com.wingbels.belssagecore.entities.Bctask;

public class Bcemployeeprofile {
	private Bcemployees employee;
	private List<Bccareers> employeecareers;
	private List<Bctask> employeetasks;
	private List<Bcdocuments> employeedocuments;

	public List<Bcdocuments> getEmployeedocuments() {
		return employeedocuments;
	}

	public void setEmployeedocuments(List<Bcdocuments> employeedocuments) {
		this.employeedocuments = employeedocuments;
	}

	public Bcemployees getEmployee() {
		return employee;
	}

	public void setEmployee(Bcemployees employee) {
		this.employee = employee;
	}

	public List<Bccareers> getEmployeecareers() {
		return employeecareers;
	}

	public void setEmployeecareers(List<Bccareers> employeecareers) {
		this.employeecareers = employeecareers;
	}

	public List<Bctask> getEmployeetasks() {
		return employeetasks;
	}

	public void setEmployeetasks(List<Bctask> employeetasks) {
		this.employeetasks = employeetasks;
	}

}