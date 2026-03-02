package com.wingbels.belssagecore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wingbels.belssagecore.entities.Bccareers;
import com.wingbels.belssagecore.entities.Bcemployees;
@Service
public interface Bccareersservice {
	public Bccareers save(Bccareers bccareer );
	public void delete(Long idcareer);
	int createCareer(Bccareers bccareer );
    int updateCareer(Bccareers bccareer);
    public Optional<Bccareers> findcareerbyid(Long idbccareer);
    public List<Bccareers> findcareersEmp(Bcemployees Emp);
    public Bccareers findlastmodifoncareer (Long idemp);
	

}
