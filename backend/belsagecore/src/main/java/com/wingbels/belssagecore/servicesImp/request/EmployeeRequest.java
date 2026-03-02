package com.wingbels.belssagecore.servicesImp.request;

import java.time.LocalDate;

import com.wingbels.belssagecore.entities.Bcdepartments;
import com.wingbels.belssagecore.entities.Bcemployees;

public class EmployeeRequest {
	private Bcemployees employee;
	private LocalDate effectifModifDate;
	private LocalDate ModifDate;
	private String previousEmpTitle;
	private String newEmpTitle;
	private Bcdepartments previousEmpDept;
	private Bcdepartments newEmpDept;
	private String reasonJobChange;
	public EmployeeRequest(Bcemployees employee, LocalDate effectifModifDate, LocalDate modifDate,
			String previousEmpTitle, String newEmpTitle, Bcdepartments previousEmpDept, Bcdepartments newEmpDept,
			String reasonJobChange) {
		this.employee = employee;
		this.effectifModifDate = effectifModifDate;
		ModifDate = modifDate;
		this.previousEmpTitle = previousEmpTitle;
		this.newEmpTitle = newEmpTitle;
		this.previousEmpDept = previousEmpDept;
		this.newEmpDept = newEmpDept;
		this.reasonJobChange = reasonJobChange;
	}

	public Bcemployees getEmployee() {
		return employee;
	}
	public void setEmployee(Bcemployees employee) {
		this.employee = employee;
	}
	public LocalDate getEffectifModifDate() {
		return effectifModifDate;
	}
	public void setEffectifModifDate(LocalDate effectifModifDate) {
		this.effectifModifDate = effectifModifDate;
	}
	public LocalDate getModifDate() {
		return ModifDate;
	}
	public void setModifDate(LocalDate modifDate) {
		ModifDate = modifDate;
	}
	public String getPreviousEmpTitle() {
		return previousEmpTitle;
	}
	public void setPreviousEmpTitle(String previousEmpTitle) {
		this.previousEmpTitle = previousEmpTitle;
	}
	public String getNewEmpTitle() {
		return newEmpTitle;
	}
	public void setNewEmpTitle(String newEmpTitle) {
		this.newEmpTitle = newEmpTitle;
	}
	public Bcdepartments getPreviousEmpDept() {
		return previousEmpDept;
	}
	public void setPreviousEmpDept(Bcdepartments previousEmpDept) {
		this.previousEmpDept = previousEmpDept;
	}
	public Bcdepartments getNewEmpDept() {
		return newEmpDept;
	}
	public void setNewEmpDept(Bcdepartments newEmpDept) {
		this.newEmpDept = newEmpDept;
	}

	public String getReasonJobChange() {
		return reasonJobChange;
	}
	public void setReasonJobChange(String reasonJobChange) {
		this.reasonJobChange = reasonJobChange;
	}
	
}
