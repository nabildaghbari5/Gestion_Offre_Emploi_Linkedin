package com.wingbels.belssagecore.services;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.wingbels.belssagecore.entities.Bcfunctionality;

@Service
public interface Bcfunctionalityservice {

	Bcfunctionality save(Bcfunctionality functionality);

	Bcfunctionality findById(Long id);

	List<Bcfunctionality> findAll();

	void delete(Long id);

	Set<Bcfunctionality> getUserFunctionalities();

}
