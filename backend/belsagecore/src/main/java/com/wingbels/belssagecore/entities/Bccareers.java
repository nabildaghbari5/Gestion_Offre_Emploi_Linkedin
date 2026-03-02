package com.wingbels.belssagecore.entities;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Bccareers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idcareer;
	@ManyToOne
	private Bcemployees employee;
	private LocalDate effectifModifDate;
	private LocalDate ModifDate;
	private String previousEmpTitle;
	private String newEmpTitle;
	@ManyToOne
	private Bcdepartments previousEmpDept;
	@ManyToOne
	private Bcdepartments newEmpDept;
	@OneToOne(optional = true)
	private Bcrequests request;

	public Bcrequests getRequest() {
		return request;
	}

	public void setRequest(Bcrequests request) {
		this.request = request;
	}

	private String reasonJobChange;

	public Long getIdcareer() {
		return idcareer;
	}

	public void setIdcareer(Long idcareer) {
		this.idcareer = idcareer;
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
