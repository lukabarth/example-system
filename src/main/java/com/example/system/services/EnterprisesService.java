package com.example.system.services;

import com.example.system.dtos.EnterpriseRecordDto;
import com.example.system.models.EnterpriseModel;
import com.example.system.repositories.EmployeeRepository;
import com.example.system.repositories.EnterpriseRepository;
import com.example.system.repositories.PartnerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import java.util.stream.Collectors;

@AllArgsConstructor
public class EnterprisesService {

    private final PartnerRepository partnerRepository;
    private final EnterpriseRepository enterpriseRepository;
    private final EmployeeRepository employeeRepository;

    @Transactional
    public EnterpriseModel saveEnterprise(EnterpriseRecordDto enterpriseRecordDto) {
        EnterpriseModel enterprise = new EnterpriseModel();
        enterprise.setRazao_social(enterpriseRecordDto.razaoSocial());
        enterprise.setCnpj(enterpriseRecordDto.cnpj());
        enterprise.setCidade(enterpriseRecordDto.cidade());
        enterprise.setEstado(enterpriseRecordDto.estado());
        enterprise.setPartners(partnerRepository.findById(enterpriseRecordDto.id()).stream().collect(Collectors.toSet()));

        return enterpriseRepository.save(enterprise);
    }
}
