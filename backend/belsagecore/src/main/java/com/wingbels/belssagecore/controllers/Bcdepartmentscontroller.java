package com.wingbels.belssagecore.controllers;


import com.wingbels.belssagecore.servicesImp.request.FilterDepartment;
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

import com.wingbels.belssagecore.entities.Bcdepartments;
import com.wingbels.belssagecore.services.Bcdepartmentsservice;

@RestController
@RequestMapping("/api/core/department")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Bcdepartmentscontroller {
    @Autowired
    Bcdepartmentsservice bcdepartmentsservice;

    @PostMapping("/departmentcreation")
    public ResponseEntity<?> createDepartemet(@RequestBody Bcdepartments department) {
        try {
            return ResponseEntity.ok(bcdepartmentsservice.createDepartment(department));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/departmentdelete/{codecompany}")
    public ResponseEntity<?> delete(@PathVariable Long codecompany) {
        try {
            bcdepartmentsservice.delete(codecompany);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @PutMapping("/departmentupdate")
    public ResponseEntity<?> updateDepartemet(@RequestBody Bcdepartments department) {
        try {
            return ResponseEntity.ok(bcdepartmentsservice.updateDepartment(department));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @GetMapping("/departmentconsult/{codedept}")
    public ResponseEntity<?> findbycodedept(@PathVariable Long codedept) {
        try {
            return ResponseEntity.ok(bcdepartmentsservice.findbycodedept(codedept));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @GetMapping("/departmentlist")
    public ResponseEntity<?> findall() {
        try {
            return ResponseEntity.ok(bcdepartmentsservice.findall());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(-1);
        }
    }

    @PostMapping("/filter-department")
    public ResponseEntity<?> filterDepartments(@RequestBody FilterDepartment department) {
        try {
            return ResponseEntity.ok(bcdepartmentsservice.filterDepartments(department));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

