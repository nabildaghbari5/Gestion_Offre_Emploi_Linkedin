package com.wingbels.belssagecore.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.wingbels.belssagecore.servicesImp.request.FilterCompany;
import org.springframework.stereotype.Service;

import com.wingbels.belssagecore.entities.Bccompanies;

@Service
public interface Bccompaniesservice {
	public Bccompanies save(Bccompanies bccompanies);
	public void delete(Long lccompanies);
	public Optional<Bccompanies> findbyid(Long lbccompanies);
	public List<Bccompanies> findall();
	int updateCompany(Bccompanies company);
	int createGroup(Bccompanies company);
	int updateGroup(Bccompanies company);
	int createCompany(Bccompanies company);
	List<Bccompanies> findassociatedcompanies(Bccompanies company);
	Map<Bccompanies, List<Bccompanies>> visualizeGroupOrganization(Long companyId);

    List<Bccompanies> filterCompanies(FilterCompany company);
}
