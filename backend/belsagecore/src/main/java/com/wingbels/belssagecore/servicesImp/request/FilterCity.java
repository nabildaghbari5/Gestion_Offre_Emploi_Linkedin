package com.wingbels.belssagecore.servicesImp.request;

import com.wingbels.belssagecore.entities.Bccountries;

public class FilterCity {

    private String namecity;
    private Bccountries countrycity;

    public void setNamecity(String namecity) {
        this.namecity = namecity;
    }

    public void setCountrycity(Bccountries countrycity) {
        this.countrycity = countrycity;
    }

    public String getNamecity() {
        return namecity;
    }

    public Bccountries getCountrycity() {
        return countrycity;
    }
}
