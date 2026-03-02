package com.wingbels.belssagecore.servicesImp;

import java.util.List;

import com.wingbels.belssagecore.repositories.filter.CountrySpecification;
import com.wingbels.belssagecore.servicesImp.request.FilterCountry;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wingbels.belssagecore.entities.Bccountries;
import com.wingbels.belssagecore.repositories.Bccountriesrepository;
import com.wingbels.belssagecore.services.Bccountriesservice;

@Service
public class Bccountriesserviceimp implements Bccountriesservice{
	
	@Autowired
	Bccountriesrepository bccountriesrepository;

	@Override
	public Bccountries save(Bccountries Bccountries) {
		return bccountriesrepository.save(Bccountries);
	}

	@Override
	public void delete(String lcontry) {
		
	}

	@Override
	public Bccountries findbyid(String lcontry) {
		return bccountriesrepository.findById(lcontry).orElse(null);
	}

	@Override
	public List<Bccountries> findall() {
		return bccountriesrepository.findAll();
	}
	
	@Override
	public int createCountry(Bccountries bccompanies) {
		Bccountries foundcountry = findbyid(bccompanies.getCodecountry());
		if (foundcountry == null) {
			return save(bccompanies) != null ? 1 : 2 ;
		}
		return 3;
	}

	@Override
	public List<Bccountries> filterCountries(FilterCountry country) {
		return bccountriesrepository.findAll(CountrySpecification.filterCountries(country));
	}
}
