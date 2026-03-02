package com.wingbels.belssagecore.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Bcfunctionality {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idfunctionality;

    @Column(unique = true, nullable = false)
    private String namefunctionality;
    
    @Column(unique = true, nullable = false)
    private String codefunctionality;
    
    @Column( nullable = false)
    private String namemodule;

    @ManyToMany(mappedBy = "functionalities")
    private Set<Bcprofiles> profiles;


    public Bcfunctionality(String namefunctionality) {
        this.namefunctionality = namefunctionality;
    }

    public Long getIdfunctionality() {
        return idfunctionality;
    }

    public void setIdfunctionality(Long idfunctionality) {
        this.idfunctionality = idfunctionality;
    }

    public String getNamefunctionality() {
        return namefunctionality;
    }

    public void setNamefunctionality(String namefunctionality) {
        this.namefunctionality = namefunctionality;
    }

    public Set<Bcprofiles> getProfiles() {
        return profiles;
    }

    public void setProfiles(Set<Bcprofiles> profiles) {
        this.profiles = profiles;
    }
}