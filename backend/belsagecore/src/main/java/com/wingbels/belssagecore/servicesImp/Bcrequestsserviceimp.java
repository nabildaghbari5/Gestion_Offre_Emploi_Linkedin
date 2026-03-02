package com.wingbels.belssagecore.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wingbels.belssagecore.entities.Bcrequests;
import com.wingbels.belssagecore.repositories.Bcrequestsrepository;
import com.wingbels.belssagecore.services.Bcrequestsservice;

@Service
public class Bcrequestsserviceimp implements Bcrequestsservice {

	@Autowired
	Bcrequestsrepository bcrequestsrepository;

	@Override
	public Bcrequests save(Bcrequests request) {
		return bcrequestsrepository.save(request);

	}

	@Override
	public int createRequest(Bcrequests request) {
		return save(request) != null ? 1 : 2;
	}

	@Override
	public int updateRequest(Bcrequests request) {
		return save(request) != null ? 1 : 2;
	}

	@Override
	public List<Bcrequests> findEmpRequest(Long idemp) {
		return bcrequestsrepository.findByEmployeeIdemployee(idemp);
	}

}
