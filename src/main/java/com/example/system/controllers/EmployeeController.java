package com.example.system.controllers;

import com.example.system.dtos.EmployeeRecordDto;
import com.example.system.models.EmployeeModel;
import com.example.system.repositories.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/funcionarios")
    public ResponseEntity<List<EmployeeModel>> getAllEmployers() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeRepository.findAll());
    }

    @GetMapping("/funcionarios/{id}")
    public ResponseEntity<Object> getOneEmployee(@PathVariable(value = "id") UUID id) {
        Optional<EmployeeModel> employeeO = employeeRepository.findById(id);
        if (employeeO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(employeeO.get());
    }

    @PostMapping("/funcionarios")
    public ResponseEntity<EmployeeModel> saveEmployee(@RequestBody EmployeeRecordDto employeeRecordDto) {
        var emplpoyeeModel = new EmployeeModel();
        BeanUtils.copyProperties(employeeRecordDto, emplpoyeeModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeRepository.save(emplpoyeeModel));
    }

    @PutMapping("/funcionarios/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable(value = "id") UUID id,
                                                 @RequestBody EmployeeRecordDto employeeRecordDto) {
        Optional<EmployeeModel> employeeO = employeeRepository.findById(id);
        if (employeeO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado.");
        }

        var employeeModel = employeeO.get();
        BeanUtils.copyProperties(employeeRecordDto, employeeModel);

        return ResponseEntity.status(HttpStatus.OK).body(employeeRepository.save(employeeModel));
    }

    @DeleteMapping("/funcionarios/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable(value = "id") UUID id) {
        Optional<EmployeeModel> employeeO = employeeRepository.findById(id);
        if (employeeO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado.");
        }

        employeeRepository.delete(employeeO.get());

        return ResponseEntity.status(HttpStatus.OK).body("Funcionário deletado com sucesso.");
    }
}
