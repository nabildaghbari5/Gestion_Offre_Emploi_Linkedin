package com.wingbels.belssagecore.servicesImp;

import java.util.List;
import java.util.Optional;

import com.wingbels.belssagecore.repositories.filter.CitySpecifications;
import com.wingbels.belssagecore.servicesImp.request.FilterCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wingbels.belssagecore.entities.Bccities;
import com.wingbels.belssagecore.entities.Bccountries;
import com.wingbels.belssagecore.repositories.Bccitiesrepository;
import com.wingbels.belssagecore.services.Bccitiesservice;
import com.wingbels.belssagecore.services.Bccountriesservice;

@Service
public class Bccitiesserviceimp implements Bccitiesservice {
	
	@Autowired
	Bccitiesrepository repoBccitiesrepository;
	@Autowired
	Bccountriesservice serviceCountry;

	@Override
	public Bccities save(Bccities bccities) {
		return repoBccitiesrepository.save(bccities);
	}

	@Override
	public void delete(Long lbccities) {
		repoBccitiesrepository.deleteById(lbccities);
	}

	@Override
	public Optional<Bccities> findbyid(Long lbccities) {
		return repoBccitiesrepository.findById(lbccities);
	}

	@Override
	public List<Bccities> findall() {
		return repoBccitiesrepository.findAll();
	}

	@Override
	public List<Bccities> findbycountry(String country) {
		return repoBccitiesrepository.findByCountrycity(serviceCountry.findbyid(country));
	}
	
	@Override
	public Bccities cityCreation(Bccities bccities) {
		return save(bccities);
	}

	@Override
	public Bccities updateCity(Bccities bccities) {
		return repoBccitiesrepository.save(bccities);
	}

	@Override
	public List<Bccities> filterCities(FilterCity city) {
		return repoBccitiesrepository.findAll(CitySpecifications.filterCities(city));
	}

}
