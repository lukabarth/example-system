package com.example.system.controllers;

import com.example.system.models.PartnerModel;
import com.example.system.repositories.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PartnerController {

    @Autowired
    PartnerRepository partnerRepository;

    @GetMapping("/socios")
    public ResponseEntity<List<PartnerModel>> getAllPartners() {
        return ResponseEntity.status(HttpStatus.OK).body(partnerRepository.findAll());
    }
}
