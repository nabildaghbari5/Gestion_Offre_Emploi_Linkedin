package com.wingbels.belssagecore.servicesImp.request;

import com.wingbels.belssagecore.entities.Bccities;
import com.wingbels.belssagecore.entities.Bccountries;

public class FilterZipcode {
    private String locationzipcode;
    private String codezipcode;
    private Bccities cityzipcode;
    private Bccountries countryzipcode;

    public String getLocationzipcode() {
        return locationzipcode;
    }

    public void setLocationzipcode(String locationzipcode) {
        this.locationzipcode = locationzipcode;
    }

    public String getCodezipcode() {
        return codezipcode;
    }

    public void setCodezipcode(String codezipcode) {
        this.codezipcode = codezipcode;
    }

    public Bccities getCityzipcode() {
        return cityzipcode;
    }

    public void setCityzipcode(Bccities cityzipcode) {
        this.cityzipcode = cityzipcode;
    }

    public Bccountries getCountryzipcode() {
        return countryzipcode;
    }

    public void setCountryzipcode(Bccountries countryzipcode) {
        this.countryzipcode = countryzipcode;
    }
}
