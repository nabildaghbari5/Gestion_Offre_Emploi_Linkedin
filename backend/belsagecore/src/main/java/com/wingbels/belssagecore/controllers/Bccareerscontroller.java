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

import com.wingbels.belssagecore.entities.Bccareers;
import com.wingbels.belssagecore.entities.Bcemployees;
import com.wingbels.belssagecore.services.Bccareersservice;

@RestController
@RequestMapping("/api/core/carrer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Bccareerscontroller {

	@Autowired
	Bccareersservice bccareersservice;


	@PostMapping("/careercreation")
	public ResponseEntity<?> createCareer(@RequestBody Bccareers career) {
		try {
			return ResponseEntity.ok(bccareersservice.createCareer(career));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}

	@DeleteMapping("/careerdelete/{idcareer}")
	public ResponseEntity<?> delete(@PathVariable Long idcareer) {
		try {
			bccareersservice.delete(idcareer);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}

	@PutMapping("/careerupdate")
	public ResponseEntity<?> updateCareer(@RequestBody Bccareers bccareer) {
		try {
			return ResponseEntity.ok(bccareersservice.updateCareer(bccareer));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}

	@GetMapping("/listEmpCareer/{idemp}")
	public ResponseEntity<?> findcareersEmp(@PathVariable Bcemployees emp) {
		try {
			return ResponseEntity.ok(bccareersservice.findcareersEmp(emp));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}

	@GetMapping("/cosultlastmodifoncareer/{idemp}")
	public ResponseEntity<?> findlastmodifoncareer(@PathVariable Bcemployees idemp) {
		try {
			return ResponseEntity.ok(bccareersservice.findcareersEmp(idemp));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}
}
