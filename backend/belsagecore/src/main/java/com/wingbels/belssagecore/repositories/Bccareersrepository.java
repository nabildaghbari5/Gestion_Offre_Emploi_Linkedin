package com.wingbels.belssagecore.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wingbels.belssagecore.entities.Bccareers;
import com.wingbels.belssagecore.entities.Bcemployees;
@Repository
public interface Bccareersrepository extends JpaRepository<Bccareers, Long> {
	
	public List<Bccareers > findByEmployee(Bcemployees emp);
	public Bccareers findTopByEmployee_IdemployeeAndEffectifModifDateLessThanEqual(Long idemployee, LocalDate date );
	
}
