package com.example.system.repositories;

import com.example.system.models.EnterpriseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnterpriseRepository extends JpaRepository<EnterpriseModel, UUID> {

}
