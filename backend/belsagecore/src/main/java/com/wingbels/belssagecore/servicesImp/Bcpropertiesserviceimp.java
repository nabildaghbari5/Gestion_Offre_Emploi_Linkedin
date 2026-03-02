package com.wingbels.belssagecore.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wingbels.belssagecore.entities.Bcproperties;
import com.wingbels.belssagecore.repositories.Bcpropertiesrepository;
import com.wingbels.belssagecore.services.Bcpropertiesservice;

@Service
public class Bcpropertiesserviceimp implements Bcpropertiesservice {
	
	@Autowired
	Bcpropertiesrepository bcpropertiesrepository;

	@Override
	public Bcproperties save(Bcproperties bcproperties) {
		return bcpropertiesrepository.save(bcproperties);
	}

	@Override
	public List<Bcproperties> findall() {
		return bcpropertiesrepository.findAll();
	}

}
