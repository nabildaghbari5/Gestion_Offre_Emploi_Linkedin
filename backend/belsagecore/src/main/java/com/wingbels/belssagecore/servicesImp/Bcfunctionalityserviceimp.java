package com.wingbels.belssagecore.servicesImp;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wingbels.belssagecore.entities.Bcfunctionality;
import com.wingbels.belssagecore.entities.Bcusers;
import com.wingbels.belssagecore.repositories.Bcfunctionalityrepository;
import com.wingbels.belssagecore.services.Bcfunctionalityservice;
import com.wingbels.belssagecore.services.Bckeycloakservice;
import com.wingbels.belssagecore.services.Bcusersservice;

@Service
public class Bcfunctionalityserviceimp implements Bcfunctionalityservice {
	

    @Autowired
    private Bcfunctionalityrepository functionalityRepository;

    @Autowired
    private Bcusersservice userservice;
    @Autowired
    Bckeycloakservice bckeycloakservice;

    @Override
    public Bcfunctionality save(Bcfunctionality functionality) {
        return functionalityRepository.save(functionality);
    }

    @Override
    public Bcfunctionality findById(Long id) {
        return functionalityRepository.findById(id).orElse(null);
    }

    @Override
    public List<Bcfunctionality> findAll() {
        return functionalityRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        functionalityRepository.deleteById(id);
    }

    @Override
    public Set<Bcfunctionality> getUserFunctionalities() {
        Bcusers user = userservice.findbyid(bckeycloakservice.findUserKey()).orElseThrow();
        if (user == null) {
            return Collections.emptySet();
        }

        return user.getProfiles().getFunctionalities();
    }
}