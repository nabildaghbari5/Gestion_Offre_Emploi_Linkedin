package com.wingbels.belssagecore.controllers;

import com.wingbels.belssagecore.entities.Bcfunctionality;
import com.wingbels.belssagecore.entities.Bcusers;
import com.wingbels.belssagecore.services.Bcfunctionalityservice;
import com.wingbels.belssagecore.services.Bcusersservice;
import com.wingbels.belssagecore.servicesImp.request.FilterUser;
import com.wingbels.belssagecore.servicesImp.request.UserRequest;

import java.util.Set;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/core/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Bcuserscontroller {

    @Autowired
    private Bcusersservice userService;
    @Autowired
    Bcfunctionalityservice functionnalityservice;

    @PostMapping("/add-user")
    public ResponseEntity<?> addUser(@RequestBody UserRequest user) {
        try {
            return ResponseEntity.ok(userService.createUser(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get-users")
    public ResponseEntity<?> getAllUsers() {
        try {
            return ResponseEntity.ok(userService.findall());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @GetMapping("/get-user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(userService.findbyid(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }
    
    @PutMapping("/update-user")
    public ResponseEntity<?> updateUser(@RequestBody Bcusers user) {
        try {
            return ResponseEntity.ok(userService.save(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        try {
            userService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }
    
    @GetMapping("/functionalities")
    public ResponseEntity<Set<Bcfunctionality>> getUserFunctionalities() {

        Set<Bcfunctionality> functionalities = functionnalityservice.getUserFunctionalities();
        return ResponseEntity.ok(functionalities);
    }
    
    @GetMapping("/isHumanRessourceManagerGroup")
    public ResponseEntity<?> isHumanRessourceManagerGroup() {
        return ResponseEntity.ok(userService.isGroupHRManager());
    }

    @PostMapping("filter-users")
    public ResponseEntity<?> filterUsers(@RequestBody FilterUser user){
        try {
            return ResponseEntity.ok(userService.filterUsers(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
