package com.wingbels.belssagecore.servicesImp.request;

import com.wingbels.belssagecore.entities.Bcemployees;
import com.wingbels.belssagecore.enumerations.Bcstatustask;
import com.wingbels.belssagecore.enumerations.Bctaskstatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FilterTask {
    private String title;
    private String description;
    private LocalDate startdate;
    private LocalDate enddate;
    private LocalDateTime createdat;
    private Bctaskstatus status;
    private Bcemployees assignedTo;
    private Bcemployees createdBy;
    private Bcemployees employee;

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

    public Bctaskstatus getStatus() {
        return status;
    }

    public void setStatus(Bctaskstatus status) {
        this.status = status;
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

    public Bcemployees getEmployee() {
        return employee;
    }

    public void setEmployee(Bcemployees employee) {
        this.employee = employee;
    }
}
