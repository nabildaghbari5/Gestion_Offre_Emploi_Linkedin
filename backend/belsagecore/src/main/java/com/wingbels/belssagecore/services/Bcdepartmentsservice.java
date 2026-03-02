package com.wingbels.belssagecore.services;

import java.util.List;
import java.util.Optional;

import com.wingbels.belssagecore.servicesImp.request.FilterDepartment;
import org.springframework.stereotype.Service;
import com.wingbels.belssagecore.entities.Bcdepartments;

@Service
public interface Bcdepartmentsservice {
	public Bcdepartments save(Bcdepartments bcdepartments);
	public void delete(Long codebcdepartment);
	public Optional<Bcdepartments> findbyid(Long idbcdepartment);
	public Optional<Bcdepartments> findbycodedept(Long codebcdepartment);
	public List<Bcdepartments> findall();
	int createDepartment(Bcdepartments bcdepartment); 
	int updateDepartment(Bcdepartments bcdepartment);
	List<Bcdepartments> filterDepartments(FilterDepartment department);

}
