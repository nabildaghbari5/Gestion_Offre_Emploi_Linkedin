package com.wingbels.belssagecore.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.wingbels.belssagecore.entities.Bccompanies;

@Repository
public interface Bccompaniesrepository extends JpaRepository<Bccompanies, Long>, JpaSpecificationExecutor<Bccompanies> {
	public Optional<Bccompanies> findByFiscalcodecompany(String fiscalcodecompany);
	public Optional<Bccompanies> findByNamecompany(String namecompany);
	public List<Bccompanies> findByAssociatedgroup(Bccompanies companyid);

}
