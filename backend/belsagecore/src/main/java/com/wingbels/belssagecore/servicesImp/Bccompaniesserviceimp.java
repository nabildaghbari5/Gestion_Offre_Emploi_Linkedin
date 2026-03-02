package com.wingbels.belssagecore.servicesImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.wingbels.belssagecore.entities.Bcaddress;
import com.wingbels.belssagecore.repositories.Bcaddressrepository;
import com.wingbels.belssagecore.repositories.filter.CompanySpecifications;
import com.wingbels.belssagecore.servicesImp.request.FilterCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wingbels.belssagecore.entities.Bccompanies;
import com.wingbels.belssagecore.repositories.Bccompaniesrepository;
import com.wingbels.belssagecore.services.Bccompaniesservice;

@Service
public class Bccompaniesserviceimp implements Bccompaniesservice {
	
	@Autowired
	Bccompaniesrepository bccompaniesrepository;
	@Autowired
	Bcaddressrepository addressRepository;

	@Override
	public Bccompanies save(Bccompanies bccompanies) {
		return bccompaniesrepository.save(bccompanies);
	}

	@Override
	public void delete(Long lccompanies) {
		bccompaniesrepository.deleteById(lccompanies);
	}

	@Override
	public Optional<Bccompanies> findbyid(Long lccompanies) {
		return bccompaniesrepository.findById(lccompanies);
	}
	
	public Bccompanies findbyfiscalid(String fiscalid) {
		Optional<Bccompanies> company = bccompaniesrepository.findByFiscalcodecompany(fiscalid);
		return company.isPresent() ? company.get() : null;
	}

	@Override
	public List<Bccompanies> findall() {
		return bccompaniesrepository.findAll();
	}
	
	@Override
	public int createGroup(Bccompanies company) {
		Bccompanies foundcompany = findbyfiscalid(company.getFiscalcodecompany());
		if (foundcompany == null) {
			company.setGroupcompnay(true);
			Bcaddress bcaddress = company.getAddresscompany();
			addressRepository.save(bcaddress);
			return save(company) != null ? 1 : 2;
		}
		return 3;
	}
	@Override
	public int updateCompany(Bccompanies company) {
		return save(company) != null ? 1 : 2;
	}
	
	@Override
	public int updateGroup(Bccompanies company) {
		return save(company) != null ? 1 : 2;
	}

	@Override
	public int createCompany(Bccompanies company) {
		Bccompanies foundcompany = findbyfiscalid(company.getFiscalcodecompany());
		if (foundcompany == null) {
			return save(company) != null ? 1 : 2;
		}
		return 3;
	}
	
	@Override
	public List<Bccompanies> findassociatedcompanies(Bccompanies company){
		return bccompaniesrepository.findByAssociatedgroup(company);
	}
	
	@Override
	public Map<Bccompanies, List<Bccompanies>> visualizeGroupOrganization (Long companyId){
		Optional<Bccompanies> company = findbyid(companyId);
		
		Map<Bccompanies, List<Bccompanies>> companyorganization = new HashMap<Bccompanies, List<Bccompanies>>();
		if (company.isPresent()) {
			Bccompanies companyfound = company.get();
			if (companyfound.isGroupcompnay()) {
				companyorganization.put(companyfound, findassociatedcompanies(companyfound));
			}
				return companyorganization;
		}
		return null;
	}

	@Override
	public List<Bccompanies> filterCompanies(FilterCompany company) {
		return bccompaniesrepository.findAll(CompanySpecifications.filterCompany(company));
	}
}
