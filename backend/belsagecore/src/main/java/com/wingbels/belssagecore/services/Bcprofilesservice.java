package com.wingbels.belssagecore.services;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.wingbels.belssagecore.entities.Bcfunctionality;
import com.wingbels.belssagecore.entities.Bcprofiles;

@Service
public interface Bcprofilesservice {
	Bcprofiles save(Bcprofiles profile);
	Bcprofiles findbyid(Long id);
    List<Bcprofiles> findall();
    void delete(Long id);
    void addFunctionalityToProfile(Long profileId, Long functionalityId);
	Set<Bcfunctionality> getFunctionalitiesByProfile(Long profileId);
}
