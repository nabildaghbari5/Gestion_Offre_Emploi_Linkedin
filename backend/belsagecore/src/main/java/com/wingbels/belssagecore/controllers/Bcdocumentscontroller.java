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
import org.springframework.web.multipart.MultipartFile;

import com.wingbels.belssagecore.entities.Bcemployees;
import com.wingbels.belssagecore.services.Bcdocumentsservice;

@RestController
@RequestMapping("/api/core/document")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Bcdocumentscontroller {
	@Autowired
	Bcdocumentsservice bcdocumentsservice;

	@PostMapping("/documentcreation")
	public ResponseEntity<?> createdocument(@RequestBody MultipartFile file, Long idemployee) {
		try {
			return ResponseEntity.ok(bcdocumentsservice.createDocument( file,  idemployee));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}

	@DeleteMapping("/documentdelete/{idocument}")
	public ResponseEntity<?> delete(@PathVariable Long iddocument) {
		try {
			bcdocumentsservice.delete(iddocument);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}

	@PutMapping("/documentupdate")
	public ResponseEntity<?> updatedocument(@RequestBody MultipartFile file, Long idemployee) {
		try {
			return ResponseEntity.ok(bcdocumentsservice.updateDocument(file,  idemployee));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}

	@GetMapping("/listAlldocuments")
	public ResponseEntity<?> findalldocuments() {
		try {
			return ResponseEntity.ok(bcdocumentsservice.findall());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}

	@GetMapping("/listdocumentsByemp/{idemp}")
	public ResponseEntity<?> findtasksEmp(@PathVariable Bcemployees emp) {
		try {
			return ResponseEntity.ok(bcdocumentsservice.finddocumentsbyEmp(emp));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}

}
