package com.wingbels.belssagecore.services;

import java.util.List;
import java.util.Optional;

import com.wingbels.belssagecore.servicesImp.request.FilterUser;
import org.springframework.stereotype.Service;

import com.wingbels.belssagecore.entities.Bcusers;
import com.wingbels.belssagecore.servicesImp.request.UserRequest;

@Service
public interface Bcusersservice {

	public Bcusers save(Bcusers bcusers);
	public void delete(String bcusers);
	public Optional<Bcusers> findbyid(String bcusers);
	public List<Bcusers> findall();
	int createUser(UserRequest userrequest);
	int updateUser(UserRequest userrequest);
	Long isGroupHRManager();

    List<Bcusers> filterUsers(FilterUser user);
}
