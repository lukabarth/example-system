package com.example.system.repositories;

import com.example.system.models.EnterprisesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnterprisesRepository extends JpaRepository<EnterprisesModel, UUID> {

    EnterprisesModel findEnterprisesModelByCnpj(String cnpj);
    EnterprisesModel findEnterprisesModelByRazaoSocial(String razaoSocial);
}
