package com.wingbels.belssagecore.controllers;

import com.wingbels.belssagecore.servicesImp.request.FilterCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wingbels.belssagecore.entities.Bccountries;
import com.wingbels.belssagecore.services.Bccountriesservice;

@RestController
@RequestMapping("/api/core/country")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Bccountriescontroller {

    @Autowired
    Bccountriesservice bccountriesservice;

    @PostMapping("/countrycreation")
    public ResponseEntity<?> createCountry(@RequestBody Bccountries country) {
        try {
            return ResponseEntity.ok(bccountriesservice.createCountry(country));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @PutMapping("/update-country")
    public ResponseEntity<?> updateCountry(@RequestBody Bccountries country) {
        try {
            return ResponseEntity.ok(bccountriesservice.save(country));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @GetMapping("/getCountries")
    public ResponseEntity<?> getCountries() {
        try {
            return ResponseEntity.ok(bccountriesservice.findall());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @GetMapping("/get-country/{code}")
    public ResponseEntity<?> getCountry(@PathVariable String code) {
        try {
            return ResponseEntity.ok(bccountriesservice.findbyid(code));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @DeleteMapping("/delete-country/{id}")
    public ResponseEntity<?> deleteCountry(@PathVariable String id) {
        try {
            bccountriesservice.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @PostMapping("/filter-countries")
    public ResponseEntity<?> filterCountries(@RequestBody FilterCountry country) {
        try {
            return ResponseEntity.ok(bccountriesservice.filterCountries(country));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
