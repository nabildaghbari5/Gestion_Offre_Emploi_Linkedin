package com.wingbels.belssagecore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wingbels.belssagecore.entities.Bcemployees;
import com.wingbels.belssagecore.servicesImp.request.FilterEmployee;
import com.wingbels.belssagecore.servicesImp.response.Bcemployeeprofile;

@Service
public interface Bcemployeesservice {
	public Bcemployees save(Bcemployees bcemployees);
	int createEmployee(Bcemployees employee);
	public void delete(Long lbcemployees);
	public Optional<Bcemployees> findbyid(Long lbcemployees);
	public List<Bcemployees> findall();
    int updateEmployee(Bcemployees bcemployee);
    public Bcemployeeprofile employeeprofile(Long idemp);
	List<Bcemployees> findManagers();
	List<Bcemployees> filterEmployee(FilterEmployee filter);
    
}
