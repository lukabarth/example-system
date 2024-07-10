package com.example.system.services;

import com.example.system.dtos.PartnerRecordDto;
import com.example.system.models.PartnerModel;
import com.example.system.repositories.EnterpriseRepository;
import com.example.system.repositories.PartnerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import java.util.stream.Collectors;

@AllArgsConstructor
public class PartnerService {

    private final PartnerRepository partnerRepository;
    private final EnterpriseRepository enterpriseRepository;

    @Transactional
    public PartnerModel savePartner(PartnerRecordDto partnerRecordDto) {
        PartnerModel partner = new PartnerModel();
        partner.setNome(partnerRecordDto.nome());
        partner.setCpf(partnerRecordDto.cpf());
        partner.setCidade(partnerRecordDto.cidade());
        partner.setEstado(partnerRecordDto.estado());
        partner.setEnterprises(enterpriseRepository.findById(partnerRecordDto.id()).stream().collect(Collectors.toSet()));

        return partnerRepository.save(partner);
    }
}
