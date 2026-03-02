package com.wingbels.belssagecore.services;

import org.springframework.stereotype.Service;

import com.wingbels.belssagecore.servicesImp.request.UserRequest;

@Service
public interface Bckeycloakservice {

	String createUser(UserRequest userrequest);
	void updateUser(UserRequest userrequest);
	void disableUser(String userId);
	String findUserKey();


}
