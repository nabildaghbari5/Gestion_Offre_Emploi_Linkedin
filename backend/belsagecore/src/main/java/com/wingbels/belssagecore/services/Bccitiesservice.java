package com.wingbels.belssagecore.services;

import java.util.List;
import java.util.Optional;

import com.wingbels.belssagecore.servicesImp.request.FilterCity;
import org.springframework.stereotype.Service;

import com.wingbels.belssagecore.entities.Bccities;

@Service
public interface Bccitiesservice {
	public Bccities save(Bccities bccities);
	public void delete(Long lbccities);
	public Optional<Bccities> findbyid(Long lbccities);
	public List<Bccities> findall();
	public List<Bccities> findbycountry(String country);
	public Bccities cityCreation(Bccities bccities);
	public Bccities updateCity(Bccities bccities);

	List<Bccities> filterCities(FilterCity city);
}
