package com.wingbels.belssagecore.servicesImp.request;

import com.wingbels.belssagecore.entities.Bcemployees;
import com.wingbels.belssagecore.entities.Bcprofiles;
import com.wingbels.belssagecore.enumerations.Bcroleuser;

public class FilterUser {
    private String username;
    private String nameusers;
    private String surnameusers;
    private boolean enabled;
    private Bcemployees associatedemployeeuser;
    private Bcroleuser roles;
    private Bcprofiles profiles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNameusers() {
        return nameusers;
    }

    public void setNameusers(String nameusers) {
        this.nameusers = nameusers;
    }

    public String getSurnameusers() {
        return surnameusers;
    }

    public void setSurnameusers(String surnameusers) {
        this.surnameusers = surnameusers;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Bcemployees getAssociatedemployeeuser() {
        return associatedemployeeuser;
    }

    public void setAssociatedemployeeuser(Bcemployees associatedemployeeuser) {
        this.associatedemployeeuser = associatedemployeeuser;
    }

    public Bcroleuser getRoles() {
        return roles;
    }

    public void setRoles(Bcroleuser roles) {
        this.roles = roles;
    }

    public Bcprofiles getProfiles() {
        return profiles;
    }

    public void setProfiles(Bcprofiles profiles) {
        this.profiles = profiles;
    }
}
