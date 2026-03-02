package com.wingbels.belssagecore.controllers;

import com.wingbels.belssagecore.entities.Bcprofiles;
import com.wingbels.belssagecore.services.Bcprofilesservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/core/profile")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Bcprofilescontroller {

    @Autowired
    private Bcprofilesservice profilesService;

    @PostMapping("/add-profile")
    public ResponseEntity<?> addProfile(@RequestBody Bcprofiles profile) {
        try {
            return ResponseEntity.ok(profilesService.save(profile));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @GetMapping("/get-profiles")
    public ResponseEntity<?> getAllProfiles() {
        try {
            return ResponseEntity.ok(profilesService.findall());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @GetMapping("/get-profile/{id}")
    public ResponseEntity<?> getProfileById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(profilesService.findbyid(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @DeleteMapping("/delete-profile/{id}")
    public ResponseEntity<?> deleteProfile(@PathVariable Long id) {
        try {
            profilesService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }
}
