package com.wingbels.belssagecore.services;

import java.util.List;
import java.util.Optional;

import com.wingbels.belssagecore.entities.Bccities;
import com.wingbels.belssagecore.servicesImp.request.FilterZipcode;
import org.springframework.stereotype.Service;

import com.wingbels.belssagecore.entities.Bczipcode;
@Service
public interface Bczipcodeservice {
	public Bczipcode save(Bczipcode bczipcode);
	public void delete(Long bczipcode);
	public Optional<Bczipcode> findbyid(Long bczipcode);
	public Optional<Bczipcode> findByCode(String code);
	public Optional<Bczipcode> findByCity(Bccities city);
	public List<Bczipcode> findall();
	List<Bczipcode> filterZipcodes(FilterZipcode zipcode);

}
