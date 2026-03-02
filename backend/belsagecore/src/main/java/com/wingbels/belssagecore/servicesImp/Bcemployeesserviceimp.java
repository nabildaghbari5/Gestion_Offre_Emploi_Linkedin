package com.wingbels.belssagecore.servicesImp;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wingbels.belssagecore.entities.Bccareers;
import com.wingbels.belssagecore.entities.Bccontacts;
import com.wingbels.belssagecore.entities.Bcdocuments;
import com.wingbels.belssagecore.entities.Bcemployees;
import com.wingbels.belssagecore.entities.Bctask;
import com.wingbels.belssagecore.repositories.Bcemployeesrepository;
import com.wingbels.belssagecore.repositories.filter.EmployeeSpecifications;
import com.wingbels.belssagecore.services.Bccareersservice;
import com.wingbels.belssagecore.services.Bcdocumentsservice;
import com.wingbels.belssagecore.services.Bcemployeesservice;
import com.wingbels.belssagecore.services.Bctaskservice;
import com.wingbels.belssagecore.servicesImp.request.FilterEmployee;
import com.wingbels.belssagecore.servicesImp.response.Bcemployeeprofile;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class Bcemployeesserviceimp implements Bcemployeesservice {

	@Autowired
	Bcemployeesrepository bcemployeesrepository;
	@Autowired
	Bccareersservice bccareersservice;
	@Autowired
	Bctaskservice bctaskservice;
	@Autowired
	Bcdocumentsservice bcdocumentsservice;

	@Override
	public Bcemployees save(Bcemployees bcemployees) {
		return bcemployeesrepository.save(bcemployees);
	}

	@Override
	public int createEmployee(Bcemployees bcemployee) {

		return save(bcemployee) != null ? 1 : 2;
	}

	@Override
	public void delete(Long lbcemployees) {
		bcemployeesrepository.deleteById(lbcemployees);
	}

	@Override
	public Optional<Bcemployees> findbyid(Long lbcemployees) {
		return bcemployeesrepository.findById(lbcemployees);
	}

	@Override
	public List<Bcemployees> findall() {
		return bcemployeesrepository.findAll();
	}

	@Override
	@Transactional
	public int updateEmployee(Bcemployees updatedEmployee) {
		// Fetch the current employee entity from the database
		Bcemployees currentEmployee = bcemployeesrepository.findById(updatedEmployee.getIdemployee())
		        .orElseThrow(EntityNotFoundException::new);

		// Update scalar properties of the employee entity
		currentEmployee.setFirstnameemployee(updatedEmployee.getFirstnameemployee());
		currentEmployee.setLastnameemployee(updatedEmployee.getLastnameemployee());
		currentEmployee.setBirthdateemployee(updatedEmployee.getBirthdateemployee());
		currentEmployee.setAddressemployee(updatedEmployee.getAddressemployee());
		currentEmployee.setCurrentdepartmentemployee(updatedEmployee.getCurrentdepartmentemployee());
		currentEmployee.setCurrentmanageremployee(updatedEmployee.getCurrentmanageremployee());
		currentEmployee.setCurrentpositionemployee(updatedEmployee.getCurrentpositionemployee());
		currentEmployee.setGenderemployee(updatedEmployee.getGenderemployee());

		Set<Bccontacts> existingContacts = new HashSet<>(currentEmployee.getContactemployee());

		Set<Bccontacts> updatedContacts = updatedEmployee.getContactemployee();
		Set<Bccontacts> contactsToAdd = new HashSet<>(updatedContacts);
		Set<Bccontacts> contactsToRemove = new HashSet<>(existingContacts);

		contactsToAdd.removeAll(existingContacts);
		contactsToRemove.removeAll(updatedContacts);

		for (Bccontacts contact : updatedContacts) {
		    contact.setEmployee(currentEmployee); 
		    currentEmployee.getContactemployee().add(contact); 
		}

		// Remove contacts that are no longer present
		for (Bccontacts contact : contactsToRemove) {
		    currentEmployee.getContactemployee().remove(contact);
		}

		// Save the updated employee entity
		bcemployeesrepository.save(currentEmployee);

		// Return success code
		return 1;

	}




	public Bcemployeeprofile employeeprofile(Long idemp) {
		Optional<Bcemployees> employeeopt = findbyid(idemp);
		Bcemployeeprofile employeeprofile = null;

		try {
			if (employeeopt.isPresent()) {
				Bcemployees employee = employeeopt.get();
				List<Bccareers> listcareer = bccareersservice.findcareersEmp(employee);
				List<Bctask> listtask = bctaskservice.findtaskEmp(employee);
				List<Bcdocuments> listdocument = bcdocumentsservice.finddocumentsbyEmp(employee);
				employeeprofile = new Bcemployeeprofile();
				employeeprofile.setEmployee(employee);
				employeeprofile.setEmployeecareers(listcareer);
				employeeprofile.setEmployeetasks(listtask);
				employeeprofile.setEmployeedocuments(listdocument);

			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return employeeprofile;
	}

	@Override
	public List<Bcemployees> findManagers() {
		return findall();
	}

	@Override
	public List<Bcemployees> filterEmployee(FilterEmployee filter) {
		return bcemployeesrepository.findAll(EmployeeSpecifications.filterEmployees(filter));
	}

}
