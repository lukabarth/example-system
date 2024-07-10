package com.example.system.repositories;

import com.example.system.models.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, UUID> {

}
