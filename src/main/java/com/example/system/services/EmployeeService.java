package com.example.system.services;

import com.example.system.dtos.EmployeeRecordDto;
import com.example.system.models.EmployeeModel;
import com.example.system.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Transactional
    public EmployeeModel saveEmployee(EmployeeRecordDto employeeRecordDto) {
        EmployeeModel employee = new EmployeeModel();
        employee.setNome(employeeRecordDto.nome());
        employee.setSetor(employeeRecordDto.setor());

        return employeeRepository.save(employee);
    }
}