package com.wingbels.belssagecore.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.wingbels.belssagecore.enumerations.Bcstatustask;
import com.wingbels.belssagecore.enumerations.Bctaskpriority;
import com.wingbels.belssagecore.enumerations.Bctaskstatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Bctask {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idtask;
	private String title;
	private String description;
	private LocalDate startdate;
	private LocalDate enddate;
	private LocalDateTime createdat;
	private Bcstatustask taskstatus;
	@ManyToOne
	private Bcemployees assignedTo;
	@ManyToOne
	private Bcemployees createdBy;
	private Bctaskpriority priority;
	private Bctaskstatus status;
	@ManyToOne
	private Bcemployees employee;
	@OneToMany
	private List<Bcdocuments> documents;

	public List<Bcdocuments> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Bcdocuments> documents) {
		this.documents = documents;
	}

	public Bcstatustask getTaskstatus() {
		return taskstatus;
	}

	public void setTaskstatus(Bcstatustask taskstatus) {
		this.taskstatus = taskstatus;
	}

	public Bcemployees getEmployee() {
		return employee;
	}

	public void setEmployee(Bcemployees employee) {
		this.employee = employee;
	}

	public Long getIdtask() {
		return idtask;
	}

	public void setIdtask(Long idtask) {
		this.idtask = idtask;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}

	public LocalDate getEnddate() {
		return enddate;
	}

	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}

	public LocalDateTime getCreatedat() {
		return createdat;
	}

	public void setCreatedat(LocalDateTime createdat) {
		this.createdat = createdat;
	}

	public Bcemployees getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Bcemployees assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Bcemployees getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Bcemployees createdBy) {
		this.createdBy = createdBy;
	}

	public Bctaskpriority getPriority() {
		return priority;
	}

	public void setPriority(Bctaskpriority priority) {
		this.priority = priority;
	}

	public Bctaskstatus getStatus() {
		return status;
	}

	public void setStatus(Bctaskstatus status) {
		this.status = status;
	}

}
