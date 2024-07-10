package com.example.system.dtos;

import java.util.UUID;

public record EnterpriseRecordDto(UUID id,
                                  String razaoSocial,
                                  String cnpj,
                                  String cidade,
                                  String estado) {
}
