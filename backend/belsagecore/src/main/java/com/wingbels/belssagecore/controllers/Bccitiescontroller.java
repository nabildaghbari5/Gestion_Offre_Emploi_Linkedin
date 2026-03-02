package com.wingbels.belssagecore.controllers;

import com.wingbels.belssagecore.servicesImp.request.FilterCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wingbels.belssagecore.entities.Bccities;
import com.wingbels.belssagecore.services.Bccitiesservice;

import jakarta.ws.rs.PathParam;

@RestController
@RequestMapping("/api/core/city")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Bccitiescontroller {

    @Autowired
    Bccitiesservice service;

    @GetMapping("/getCitieslinkedCountry/{country}")
    public ResponseEntity<?> getCitieslinkedCountry(@PathVariable(value = "country") String country) {
        try {
            return ResponseEntity.ok(service.findbycountry(country));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/cityfindall")
    public ResponseEntity<?> findall() {
        try {
            return ResponseEntity.ok(service.findall());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @PostMapping("/cityCreation")
    public ResponseEntity<?> cityCreation(@RequestBody Bccities bccities) {
        try {
            return ResponseEntity.ok(service.cityCreation(bccities));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @PutMapping("/update-city")
    public ResponseEntity<?> updateCity(@RequestBody Bccities bccities) {
        try {
            return ResponseEntity.ok(service.updateCity(bccities));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get-city/{id}")
    public ResponseEntity<?> getCityById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.findbyid(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @DeleteMapping("/delete-city/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/filter-cities")
    public ResponseEntity<?> FilterCities(@RequestBody FilterCity city) {
        try {
            return ResponseEntity.ok(service.filterCities(city));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
