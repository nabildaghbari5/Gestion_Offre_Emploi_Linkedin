package com.wingbels.belssagecore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wingbels.belssagecore.entities.Bcrequests;

@Repository
public interface Bcrequestsrepository extends JpaRepository<Bcrequests, Long>{
	public List<Bcrequests>findByEmployeeIdemployee(Long idemp);
	
	

}
