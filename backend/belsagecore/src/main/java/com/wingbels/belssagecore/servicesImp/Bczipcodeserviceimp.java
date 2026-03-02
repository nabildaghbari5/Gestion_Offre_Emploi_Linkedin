package com.wingbels.belssagecore.servicesImp;

import java.util.List;
import java.util.Optional;

import com.wingbels.belssagecore.entities.Bccities;
import com.wingbels.belssagecore.repositories.filter.ZipCodeSpecifications;
import com.wingbels.belssagecore.servicesImp.request.FilterZipcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wingbels.belssagecore.entities.Bczipcode;
import com.wingbels.belssagecore.repositories.Bczipcoderepository;
import com.wingbels.belssagecore.services.Bczipcodeservice;

@Service
public class Bczipcodeserviceimp implements Bczipcodeservice {
	
	@Autowired
	Bczipcoderepository bczipcoderepository;

	@Override
	public Bczipcode save(Bczipcode bczipcode) {
		return bczipcoderepository.save(bczipcode);
	}

	@Override
	public void delete(Long bczipcode) {
		bczipcoderepository.deleteById(bczipcode);
	}

	@Override
	public Optional<Bczipcode> findbyid(Long bczipcode) {
		return bczipcoderepository.findById(bczipcode);
	}

	@Override
	public Optional<Bczipcode> findByCode(String code) {
		return bczipcoderepository.findByCodezipcode(code);
	}

	@Override
	public Optional<Bczipcode> findByCity(Bccities city) {
		return bczipcoderepository.findByCityzipcode(city);
	}

	@Override
	public List<Bczipcode> findall() {
		return bczipcoderepository.findAll();
	}

	@Override
	public List<Bczipcode> filterZipcodes(FilterZipcode zipcode) {
		return bczipcoderepository.findAll(ZipCodeSpecifications.filterZipcodes(zipcode));
	}


}
