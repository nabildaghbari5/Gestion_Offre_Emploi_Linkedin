package com.wingbels.belssagecore.controllers;

import com.wingbels.belssagecore.entities.Bczipcode;
import com.wingbels.belssagecore.services.Bccitiesservice;
import com.wingbels.belssagecore.services.Bczipcodeservice;
import com.wingbels.belssagecore.servicesImp.request.FilterZipcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/core/zipcode")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Bczipcodecontroller {

    @Autowired
    Bczipcodeservice zipcodeService;

    @Autowired
    Bccitiesservice cityService;

    @PostMapping("/add-zipcode")
    public ResponseEntity<?> addZipcode(@RequestBody Bczipcode zipcode) {
        try {
            return ResponseEntity.ok(zipcodeService.save(zipcode));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @PutMapping("/update-zipcode")
    public ResponseEntity<?> updateZipcode(@RequestBody Bczipcode zipcode) {
        try {
            return ResponseEntity.ok(zipcodeService.save(zipcode));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @GetMapping("/get-zipcodes")
    public ResponseEntity<?> getAllZipCodes() {
        try {
            return ResponseEntity.ok(zipcodeService.findall());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @GetMapping("/get-zipcode/{id}")
    public ResponseEntity<?> getZipcodeById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(zipcodeService.findbyid(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @GetMapping("/get-zipcodeByCity/{id}")
    public ResponseEntity<?> getZipcodeByCity(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(zipcodeService.findByCity(cityService.findbyid(id).orElseThrow()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @GetMapping("/get-zipcodeByCode/{code}")
    public ResponseEntity<?> getZipcodeByCode(@PathVariable String code) {
        try {
            return ResponseEntity.ok(zipcodeService.findByCode(code));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @DeleteMapping("/delete-zipcode/{id}")
    public ResponseEntity<?> deleteZipcode(@PathVariable Long id) {
        try {
            zipcodeService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @PostMapping("/filter-zipcodes")
    public ResponseEntity<?> filterZipcodes(@RequestBody FilterZipcode zipcode) {
        try {
            return ResponseEntity.ok(zipcodeService.filterZipcodes(zipcode));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
