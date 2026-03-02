package com.wingbels.belssagecore.services;

import java.util.List;

import com.wingbels.belssagecore.servicesImp.request.FilterCountry;
import org.springframework.stereotype.Service;

import com.wingbels.belssagecore.entities.Bccountries;

@Service
public interface Bccountriesservice{
	public Bccountries save(Bccountries Bccountries);
	public void delete(String lcontry);
	public Bccountries findbyid(String lcontry);
	public List<Bccountries> findall();
	public int createCountry(Bccountries bccompanies);

	List<Bccountries> filterCountries(FilterCountry country);

}
