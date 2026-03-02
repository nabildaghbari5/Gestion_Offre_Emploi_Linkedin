package com.wingbels.belssagecore.servicesImp;

import java.util.List;
import java.util.Optional;

import com.wingbels.belssagecore.entities.Bcaddress;
import com.wingbels.belssagecore.repositories.Bcaddressrepository;
import com.wingbels.belssagecore.repositories.filter.DepartmentSpecifications;
import com.wingbels.belssagecore.servicesImp.request.FilterDepartment;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wingbels.belssagecore.entities.Bcdepartments;
import com.wingbels.belssagecore.repositories.Bcdepartmentsrepository;
import com.wingbels.belssagecore.services.Bcdepartmentsservice;

@Service
public class Bcdepartmentsserviceimp implements Bcdepartmentsservice{
	
	@Autowired
	Bcdepartmentsrepository bcdepartmentsrepository;


	@Override
	public Bcdepartments save(Bcdepartments bcdepartments) {
		return bcdepartmentsrepository.save(bcdepartments);
	}

	@Transactional
	@Override
	public void delete(Long codebcdepartment) {
		bcdepartmentsrepository.deleteByCodedept(codebcdepartment);
	}

	@Override
	public Optional<Bcdepartments> findbyid(Long idbcdepartment) {
		return bcdepartmentsrepository.findById(idbcdepartment);
	}
	@Override
	public Optional<Bcdepartments> findbycodedept(Long codebcdepartment) {
		return bcdepartmentsrepository.findByCodedept(codebcdepartment);
	}
	@Override
	public List<Bcdepartments> findall() {
		return bcdepartmentsrepository.findAll();
	}
	
	@Override
	public int createDepartment(Bcdepartments department) {
		
		Bcdepartments founddept= findbycodedept(department.getCodedept()).orElse(null);
		if(founddept==null) {
			return save(department) != null ? 1 : 2;
		}
		return 3;
	}
	@Override
	public int updateDepartment(Bcdepartments department){
		return save(department)!= null? 1:2;
	}

	@Override
	public List<Bcdepartments> filterDepartments(FilterDepartment department) {
		return bcdepartmentsrepository.findAll(DepartmentSpecifications.filterDepartments(department));
	}


}
