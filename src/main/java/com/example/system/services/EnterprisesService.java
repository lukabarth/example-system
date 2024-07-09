package com.example.system.services;

import com.example.system.dtos.EnterprisesRecordDto;
import com.example.system.models.EnterprisesModel;
import com.example.system.repositories.EmployeeRepository;
import com.example.system.repositories.EnterprisesRepository;
import com.example.system.repositories.PartnerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import java.util.stream.Collectors;

@AllArgsConstructor
public class EnterprisesService {

    private final PartnerRepository partnerRepository;
    private final EnterprisesRepository enterprisesRepository;
    private final EmployeeRepository employeeRepository;

    @Transactional
    public EnterprisesModel saveEnterprise(EnterprisesRecordDto enterprisesRecordDto) {
        EnterprisesModel enterprise = new EnterprisesModel();
        enterprise.setRazao_social(enterprisesRecordDto.razaoSocial());
        enterprise.setCnpj(enterprisesRecordDto.cnpj());
        enterprise.setCidade(enterprisesRecordDto.cidade());
        enterprise.setEstado(enterprisesRecordDto.estado());
        enterprise.setPartners(partnerRepository.findById(enterprisesRecordDto.id()).stream().collect(Collectors.toSet()));

        return enterprisesRepository.save(enterprise);
    }
}
