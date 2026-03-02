package com.wingbels.belssagecore.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wingbels.belssagecore.entities.Bcrequests;

@Service
public interface Bcrequestsservice {
	public Bcrequests save(Bcrequests request) ;
	public int createRequest(Bcrequests request);
	public List<Bcrequests> findEmpRequest(Long idemp);
	public int updateRequest(Bcrequests request);
	

}
