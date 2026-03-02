package com.wingbels.belssagecore.servicesImp;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wingbels.belssagecore.entities.Bccareers;
import com.wingbels.belssagecore.entities.Bcemployees;
import com.wingbels.belssagecore.repositories.Bccareersrepository;
import com.wingbels.belssagecore.services.Bccareersservice;

@Service
public class Bccareersserviceimp implements Bccareersservice {
	@Autowired
	Bccareersrepository bccareersrepository;

	public Bccareers save(Bccareers bccareer) {
		return bccareersrepository.save(bccareer);
	}

	@Override
	public void delete(Long idbccareer) {
		bccareersrepository.deleteById(idbccareer);
	}

	@Override
	public Optional<Bccareers> findcareerbyid(Long idbccareer) {
		return bccareersrepository.findById(idbccareer);
	}

	@Override
	public int createCareer(Bccareers bccareer) {
		return save(bccareer) != null ? 1 : 2;
	}

	@Override
	public int updateCareer(Bccareers bccareer) {
		return save(bccareer) != null ? 1 : 2;

	}

	@Override
	public List<Bccareers> findcareersEmp(Bcemployees Emp) {
		return bccareersrepository.findByEmployee(Emp);
	}

	@Override
	public Bccareers findlastmodifoncareer(Long idemp) {
		return bccareersrepository.findTopByEmployee_IdemployeeAndEffectifModifDateLessThanEqual(idemp,
				LocalDate.now());

	}

}
