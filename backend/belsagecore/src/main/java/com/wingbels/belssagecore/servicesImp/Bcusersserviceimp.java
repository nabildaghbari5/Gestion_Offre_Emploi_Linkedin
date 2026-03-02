package com.wingbels.belssagecore.servicesImp;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.wingbels.belssagecore.repositories.filter.UserSpecifications;
import com.wingbels.belssagecore.servicesImp.request.FilterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wingbels.belssagecore.entities.Bccompanies;
import com.wingbels.belssagecore.entities.Bcdepartments;
import com.wingbels.belssagecore.entities.Bcemployees;
import com.wingbels.belssagecore.entities.Bcusers;
import com.wingbels.belssagecore.enumerations.Bcroleuser;
import com.wingbels.belssagecore.repositories.Bcusersrepository;
import com.wingbels.belssagecore.services.Bckeycloakservice;
import com.wingbels.belssagecore.services.Bcusersservice;
import com.wingbels.belssagecore.servicesImp.request.UserRequest;

@Service
public class Bcusersserviceimp implements Bcusersservice {

	@Autowired
	Bcusersrepository bcusersrepository;
	@Autowired
	Bckeycloakservice bckeycloakservice;

	@Override
	public Bcusers save(Bcusers bcusers) {
		return bcusersrepository.save(bcusers);
	}

	@Override
	public void delete(String sbcusers) {
		bcusersrepository.deleteById(sbcusers);
	}

	@Override
	public Optional<Bcusers> findbyid(String sbcusers) {
		return bcusersrepository.findById(sbcusers);
	}

	@Override
	public List<Bcusers> findall() {
		return bcusersrepository.findAll();
	}

	@Override
	@Transactional
	public int createUser(UserRequest userrequest) {
		String userId = bckeycloakservice.createUser(userrequest);
		Bcusers user = new Bcusers(userId, userrequest.getUsername(), userrequest.getNameusers(),
				userrequest.getSurnameusers(), true, LocalDate.now(), null, userrequest.getAssociatedemployeeuser(),
				Bcroleuser.valueOf(userrequest.getRoles()));
		if (save(user) != null)

			return 1;
		return 0;
	}

	@Override
	@Transactional
	public int updateUser(UserRequest userrequest) {
		Bcusers user = findbyid(userrequest.getUidusers()).orElseThrow();
		user.setAssociatedemployeeuser(userrequest.getAssociatedemployeeuser());
		user.setDatetimelastupdate(LocalDate.now());
		user.setUsername(userrequest.getUsername());
		user.setSurnameusers(userrequest.getSurnameusers());
		user.setNameusers(userrequest.getNameusers());
		if (save(user) != null) {
			updateUser(userrequest);
			return 1;
		}

		return 0;
	}

	@Override
	public Long isGroupHRManager() {
		Optional<Bccompanies> company = findbyid(bckeycloakservice.findUserKey())
	            .map(Bcusers::getAssociatedemployeeuser)
	            .map(Bcemployees::getCurrentdepartmentemployee)
	            .map(Bcdepartments::getAssociatedcompany);
		if (company.isPresent() && company.get().isGroupcompnay())
	    return company.get().getIdcompany();
		return 0l;
	}

	@Override
	public List<Bcusers> filterUsers(FilterUser user) {
		return bcusersrepository.findAll(UserSpecifications.filterUsers(user));
	}

}
