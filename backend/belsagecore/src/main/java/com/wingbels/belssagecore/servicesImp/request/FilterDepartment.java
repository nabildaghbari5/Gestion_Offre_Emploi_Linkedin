package com.wingbels.belssagecore.servicesImp.request;

import com.wingbels.belssagecore.entities.Bccompanies;
import com.wingbels.belssagecore.entities.Bcemployees;

public class FilterDepartment {

    private long codedept;
    private String namedepartment;
    private Bcemployees managerdepartement;
    private Bccompanies associatedcompany;

    public long getCodedept() {
        return codedept;
    }

    public void setCodedept(long codedept) {
        this.codedept = codedept;
    }

    public String getNamedepartment() {
        return namedepartment;
    }

    public void setNamedepartment(String namedepartment) {
        this.namedepartment = namedepartment;
    }

    public Bcemployees getManagerdepartement() {
        return managerdepartement;
    }

    public void setManagerdepartement(Bcemployees managerdepartement) {
        this.managerdepartement = managerdepartement;
    }

    public Bccompanies getAssociatedcompany() {
        return associatedcompany;
    }

    public void setAssociatedcompany(Bccompanies associatedcompany) {
        this.associatedcompany = associatedcompany;
    }
}
