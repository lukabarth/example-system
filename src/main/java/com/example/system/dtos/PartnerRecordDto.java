package com.example.system.dtos;

import java.util.UUID;

public record PartnerRecordDto(UUID id,
                               String nome,
                               String cpf,
                               String cidade,
                               String estado) {
}
