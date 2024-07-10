package com.example.system.controllers;

import com.example.system.dtos.EnterpriseRecordDto;
import com.example.system.models.EnterpriseModel;
import com.example.system.repositories.EnterpriseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class EnterpriseController {

    @Autowired
    EnterpriseRepository enterpriseRepository;

    @GetMapping("/empresas")
    public ResponseEntity<List<EnterpriseModel>> getAllEnterprises() {
        return ResponseEntity.status(HttpStatus.OK).body(enterpriseRepository.findAll());
    }

    @GetMapping("/empresas/{id}")
    public ResponseEntity<Object> getOneEnterprise(@PathVariable(value = "id")UUID id) {
        Optional<EnterpriseModel> enterpriseO = enterpriseRepository.findById(id);
        if(enterpriseO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(enterpriseO.get());
    }

    @PostMapping("/empresas")
    public ResponseEntity<EnterpriseModel> saveEnterprise(@RequestBody EnterpriseRecordDto enterpriseRecordDto) {
        var enterpriseModel = new EnterpriseModel();
        BeanUtils.copyProperties(enterpriseRecordDto, enterpriseModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(enterpriseRepository.save(enterpriseModel));
    }
}
