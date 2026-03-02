package com.wingbels.belssagecore.servicesImp;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wingbels.belssagecore.entities.Bcfunctionality;
import com.wingbels.belssagecore.entities.Bcprofiles;
import com.wingbels.belssagecore.repositories.Bcprofilesrepository;
import com.wingbels.belssagecore.services.Bcfunctionalityservice;
import com.wingbels.belssagecore.services.Bcprofilesservice;

@Service
public class Bcprofilesserviceimp implements Bcprofilesservice {
	
	    @Autowired
	    private Bcprofilesrepository profilesRepository;
	   
	    @Autowired
	    Bcfunctionalityservice bcfunctionalityservice;

	    @Override
	    public Bcprofiles save(Bcprofiles profile) {
	        return profilesRepository.save(profile);
	    }

	    @Override
	    public Bcprofiles findbyid(Long id) {
	        return profilesRepository.findById(id).orElse(null);
	    }

	    @Override
	    public List<Bcprofiles> findall() {
	        return profilesRepository.findAll();
	    }

	    @Override
	    public void delete(Long id) {
	        profilesRepository.deleteById(id);
	    }

	    @Override
	    public void addFunctionalityToProfile(Long profileId, Long functionalityId) {
	    	Bcprofiles profile = profilesRepository.findById(profileId).orElse(null);
	        Bcfunctionality functionality = bcfunctionalityservice.findById(functionalityId);

	        if (profile != null && functionality != null) {
	            profile.getFunctionalities().add(functionality);
	            save(profile);
	        }
	    }
	    

	    @Override
	    public Set<Bcfunctionality> getFunctionalitiesByProfile(Long profileId) {
	        Bcprofiles profile = findbyid(profileId);
	        return profile != null ? profile.getFunctionalities() : null;
	    }
}
