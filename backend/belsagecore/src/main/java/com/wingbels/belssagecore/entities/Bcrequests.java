package com.wingbels.belssagecore.entities;

import java.time.LocalDate;

import com.wingbels.belssagecore.enumerations.Bcstatusrequest;
import com.wingbels.belssagecore.enumerations.Bctyperequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Bcrequests {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idrequest;
	private LocalDate requestDate;
	private Bcstatusrequest statusRequest;
	private Bctyperequest typerequest;
	@ManyToOne
	private Bcemployees employee;
	private String reason;

	public Long getIdrequest() {
		return idrequest;
	}

	public void setIdrequest(Long idrequest) {
		this.idrequest = idrequest;
	}

	public LocalDate getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(LocalDate requestDate) {
		this.requestDate = requestDate;
	}

	public Bcstatusrequest getStatusRequest() {
		return statusRequest;
	}

	public void setStatusRequest(Bcstatusrequest statusRequest) {
		this.statusRequest = statusRequest;
	}

	public Bctyperequest getTyperequest() {
		return typerequest;
	}

	public void setTyperequest(Bctyperequest typerequest) {
		this.typerequest = typerequest;
	}

	public Bcemployees getEmployee() {
		return employee;
	}

	public void setEmployee(Bcemployees employee) {
		this.employee = employee;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
