package com.wingbels.belssagecore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wingbels.belssagecore.entities.Bcrequests;
import com.wingbels.belssagecore.services.Bcrequestsservice;

@RestController
@RequestMapping("/api/core/request")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Bcrequestscontroller {
	@Autowired
	Bcrequestsservice bcrequestsservice;

	@PostMapping("/requestcreation")
	public ResponseEntity<?> createrequest(@RequestBody Bcrequests request) {
		try {
			return ResponseEntity.ok(bcrequestsservice.createRequest(request));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}

	@GetMapping("/listEmprequests/{idemp}")
	public ResponseEntity<?> findemprequest(@PathVariable Long idemp) {
		try {
			return ResponseEntity.ok(bcrequestsservice.findEmpRequest(idemp));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}

	@PutMapping("/requestupdate")
	public ResponseEntity<?> updateRequest(@RequestBody Bcrequests request) {
		try {
			return ResponseEntity.ok(bcrequestsservice.updateRequest(request));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}
}
