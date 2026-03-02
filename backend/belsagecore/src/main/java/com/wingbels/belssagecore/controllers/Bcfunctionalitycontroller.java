package com.wingbels.belssagecore.controllers;

import com.wingbels.belssagecore.entities.Bcfunctionality;
import com.wingbels.belssagecore.services.Bcfunctionalityservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Bcfunctionalitycontroller {

    @Autowired
    private Bcfunctionalityservice functionalityService;

    @PostMapping("/add-functionality")
    public ResponseEntity<?> addFunctionality(@RequestBody Bcfunctionality functionality) {
        try {
            return ResponseEntity.ok(functionalityService.save(functionality));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @GetMapping("/get-Functionalities")
    public ResponseEntity<?> getAllFunctionalities() {
        try {
            return ResponseEntity.ok(functionalityService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @DeleteMapping("/delete-functionality/{id}")
    public ResponseEntity<?> deleteFunctionality(@PathVariable Long id) {
        try {
            functionalityService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

}
