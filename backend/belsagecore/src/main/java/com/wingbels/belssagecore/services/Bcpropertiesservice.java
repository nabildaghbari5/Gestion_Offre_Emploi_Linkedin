package com.wingbels.belssagecore.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wingbels.belssagecore.entities.Bcproperties;

@Service
public interface Bcpropertiesservice {
	public Bcproperties save(Bcproperties bcproperties);
	public List<Bcproperties> findall();

}
