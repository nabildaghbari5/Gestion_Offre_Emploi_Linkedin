package com.wingbels.belssagecore.servicesImp.request;

import com.wingbels.belssagecore.entities.Bccompanies;
import com.wingbels.belssagecore.enumerations.Bctypecompanies;

public class FilterCompany {

    private String fiscalcodecompany;
    private String namecompany;
    private Bctypecompanies typecompany;
    private Bccompanies associatedgroup;

    public String getFiscalcodecompany() {
        return fiscalcodecompany;
    }

    public void setFiscalcodecompany(String fiscalcodecompany) {
        this.fiscalcodecompany = fiscalcodecompany;
    }

    public String getNamecompany() {
        return namecompany;
    }

    public void setNamecompany(String namecompany) {
        this.namecompany = namecompany;
    }

    public Bctypecompanies getTypecompany() {
        return typecompany;
    }

    public void setTypecompany(Bctypecompanies typecompany) {
        this.typecompany = typecompany;
    }

    public Bccompanies getAssociatedgroup() {
        return associatedgroup;
    }

    public void setAssociatedgroup(Bccompanies associatedgroup) {
        this.associatedgroup = associatedgroup;
    }
}
