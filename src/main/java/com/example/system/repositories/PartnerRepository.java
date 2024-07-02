package com.example.system.repositories;

import com.example.system.models.PartnerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PartnerRepository extends JpaRepository<PartnerModel, UUID> {

    PartnerModel FindPartnerModelByNome(String nome);
    PartnerModel findPartnerModelByCpf(String cpf);
}
