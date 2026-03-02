package com.wingbels.belssagecore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wingbels.belssagecore.entities.Bcemployees;
import com.wingbels.belssagecore.services.Bcemployeesservice;
import com.wingbels.belssagecore.servicesImp.request.FilterEmployee;

@RestController
@RequestMapping("/api/core/employee")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Bcemployeescontroller {
	@Autowired
	Bcemployeesservice bcemployeesservice;

	@PostMapping("/employeecreation")
	public ResponseEntity<?> createEmployee(@RequestBody Bcemployees employee) {

		try {
			return ResponseEntity.ok(bcemployeesservice.createEmployee(employee));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("/employeedelete/{employee}")
	public ResponseEntity<?> delete(@PathVariable Long employee) {
		try {
			bcemployeesservice.delete(employee);
			return ResponseEntity.ok().build();

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}

	@PutMapping("/employeeupdate")
	public ResponseEntity<?> updateEmployee(@RequestBody Bcemployees employee) {

		try {
			return ResponseEntity.ok(bcemployeesservice.updateEmployee(employee));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}

	@GetMapping("/employeefind{idemployee}")
	public ResponseEntity<?> findbyid(@PathVariable Long idemployee) {

		try {
			return ResponseEntity.ok(bcemployeesservice.findbyid(idemployee).get());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}
	
	@GetMapping("/employeefindall")
	public ResponseEntity<?> findall() {

		try {
			return ResponseEntity.ok(bcemployeesservice.findall());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}
	
	@GetMapping("/employeefindManagers")
	public ResponseEntity<?> findallManagers() {

		try {
			return ResponseEntity.ok(bcemployeesservice.findManagers());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}
	
	@GetMapping("/employeeprofile{idemployee}")
	public ResponseEntity<?> employeeprofile(@PathVariable Long idemployee) {

		try {
			return ResponseEntity.ok(bcemployeesservice.employeeprofile(idemployee));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}
	
	@PostMapping("/filterEmployee")
	public ResponseEntity<?> filterEmployee(@RequestBody FilterEmployee employee) {

		try {
			return ResponseEntity.ok(bcemployeesservice.filterEmployee(employee));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
