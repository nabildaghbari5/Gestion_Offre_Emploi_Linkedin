package com.wingbels.belssagecore.servicesImp;

import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import com.wingbels.belssagecore.services.Bckeycloakservice;
import com.wingbels.belssagecore.servicesImp.request.UserRequest;

import jakarta.ws.rs.core.Response;

import java.util.Collections;

@Service
public class Bckeycloakserviceimp implements Bckeycloakservice {

	    @Autowired
	    private UsersResource usersResource;

	    @Override
	    public String createUser(UserRequest userRequest) {
	        UserRepresentation user = new UserRepresentation();
	        user.setUsername(userRequest.getUsername());
	        user.setEmail(userRequest.getUsername());
	        user.setFirstName(userRequest.getNameusers());
	        user.setLastName(userRequest.getSurnameusers());
	        user.setEnabled(true);
	        user.setEmailVerified(false);
	        CredentialRepresentation credential = new CredentialRepresentation();
	        credential.setTemporary(false);
	        credential.setType(CredentialRepresentation.PASSWORD);
	        credential.setValue(userRequest.getPassword());
	        
	        user.setCredentials(Collections.singletonList(credential));

	        Response response = usersResource.create(user);
	        if (response.getStatus() == 201) {
	            String userId = response.getLocation().getPath().replaceAll(".*/([^/]+)$", "$1");
	            return userId;
	        } else {
	            throw new RuntimeException("Failed to create user: " + response.getStatus());
	        }
	    }

	    @Override
	    public void updateUser(UserRequest userRequest) {
	        UserRepresentation user = usersResource.get(userRequest.getUidusers()).toRepresentation();
	        user.setUsername(userRequest.getUsername());
	        user.setEmail(userRequest.getNameusers());
	        user.setFirstName(userRequest.getNameusers());
	        user.setLastName(userRequest.getSurnameusers());
	        usersResource.get(userRequest.getUidusers()).update(user);
	    }

	    @Override
	    public void disableUser(String userId) {
	        UserRepresentation user = usersResource.get(userId).toRepresentation();
	        user.setEnabled(false);
	        usersResource.get(userId).update(user);
	    }

		@Override
		public String findUserKey() {
	        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        return jwt.getSubject(); // or any other claim you need
		}
	
}