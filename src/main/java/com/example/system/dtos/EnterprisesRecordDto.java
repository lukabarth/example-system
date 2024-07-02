package com.example.system.dtos;

import java.util.UUID;

public record EnterprisesRecordDto(UUID id,
                                   String razaoSocial,
                                   String cnpj,
                                   String cidade,
                                   String estado) {
}
