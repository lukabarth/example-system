package com.example.system.controllers;

import com.example.system.dtos.PartnerRecordDto;
import com.example.system.models.PartnerModel;
import com.example.system.repositories.PartnerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PartnerController {

    @Autowired
    PartnerRepository partnerRepository;

    @GetMapping("/socios")
    public ResponseEntity<List<PartnerModel>> getAllPartners() {
        return ResponseEntity.status(HttpStatus.OK).body(partnerRepository.findAll());
    }

    @GetMapping("/socios/{id}")
    public ResponseEntity<Object> getOnePartner(@PathVariable(value = "id")UUID id) {
        Optional<PartnerModel> partnerO = partnerRepository.findById(id);
        if (partnerO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sócio não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(partnerO.get());
    }

    @PostMapping("/socios")
    public ResponseEntity<PartnerModel> savePartner(@RequestBody PartnerRecordDto partnerRecordDto) {
        var partnerModel = new PartnerModel();
        BeanUtils.copyProperties(partnerRecordDto, partnerModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(partnerRepository.save(partnerModel));
    }

    @PutMapping("/socios/{id}")
    public ResponseEntity<Object> updatePartner(@PathVariable(value = "id") UUID id,
                                                @RequestBody PartnerRecordDto partnerRecordDto) {
        Optional<PartnerModel> partnerO = partnerRepository.findById(id);
        if (partnerO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sócio não encontrado.");
        }

        var partnerModel = partnerO.get();
        BeanUtils.copyProperties(partnerRecordDto, partnerModel);

        return ResponseEntity.status(HttpStatus.OK).body(partnerRepository.save(partnerModel));
    }

    @DeleteMapping("/socios/{id}")
    public ResponseEntity<Object> deletePartner(@PathVariable(value = "id") UUID id) {
        Optional<PartnerModel> partnerO = partnerRepository.findById(id);
        if (partnerO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sócio não encontrado.");
        }

        partnerRepository.delete(partnerO.get());

        return ResponseEntity.status(HttpStatus.OK).body("Sócio deletado com sucesso.");
    }
}
