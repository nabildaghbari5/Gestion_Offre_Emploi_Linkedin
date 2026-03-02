package com.wingbels.belssagecore.controllers;

import com.wingbels.belssagecore.entities.Bccompanies;
import com.wingbels.belssagecore.services.Bccompaniesservice;
import com.wingbels.belssagecore.servicesImp.request.FilterCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/core/company")
@CrossOrigin("*")
public class Bccompaniescontroller {
	@Autowired
	Bccompaniesservice bccompaniesservice;
	
	@PostMapping("/groupcreation")
	public ResponseEntity<?> creategroup(@RequestBody Bccompanies company){
		try {
			return ResponseEntity.ok(bccompaniesservice.createGroup(company));
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}
	
	
	
	@PostMapping("/companyupdate")
	public ResponseEntity<?> updatecompany(@RequestBody Bccompanies company){
		try {
			return ResponseEntity.ok(bccompaniesservice.updateGroup(company));
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}
	
	
	
	
	@PostMapping("/groupupdate")
	public ResponseEntity<?> updategroup(@RequestBody Bccompanies company){
		try {
			return ResponseEntity.ok(bccompaniesservice.updateGroup(company));
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}

	@PutMapping("/update-company")
	public ResponseEntity<?> updateCompany(@RequestBody Bccompanies company){
		try {
			return ResponseEntity.ok(bccompaniesservice.updateCompany(company));
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
	
	@DeleteMapping("/companydelete/{idcompany}")
	public ResponseEntity<?> delete(@PathVariable Long idcompany) {
	    try {
	        bccompaniesservice.delete(idcompany);
	        return ResponseEntity.ok().build();
	    } catch (Exception e) {
	        return ResponseEntity.badRequest().body(-1);
	    }
	}
	
	
	
	@GetMapping("/companyfindbyid/{idcompany}")
	public ResponseEntity<?> findbyid(@PathVariable Long idcompany){
		try {
			return ResponseEntity.ok(bccompaniesservice.findbyid(idcompany).get());
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}
	
	
	@GetMapping("/companyfindall")
	
	public ResponseEntity<?> findall(){
		try {
			return ResponseEntity.ok(bccompaniesservice.findall());
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}

	

	@PostMapping("/companycreation")
	public ResponseEntity<?> createcompany(@RequestBody Bccompanies company){
		try {
			return ResponseEntity.ok(bccompaniesservice.createGroup(company));
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	
	
	@GetMapping("/findassociatedcompanies/{company}")
	public ResponseEntity<?> findassociatedcompanies(@PathVariable Bccompanies company){
		try {
			return ResponseEntity.ok(bccompaniesservice.findassociatedcompanies(company));
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}
	
	
	
	
	@GetMapping("/visualizeGroupOrganization/{companyid}")
	public ResponseEntity<?> visualizeGroupOrganization(@PathVariable Long companyid){
		try {
			return ResponseEntity.ok(bccompaniesservice.visualizeGroupOrganization(companyid));
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}

	@PostMapping("filter-companies")
	public ResponseEntity<?> filterCompanies(@RequestBody FilterCompany company){
		try {
			return ResponseEntity.ok(bccompaniesservice.filterCompanies(company));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
