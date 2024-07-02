package com.example.system.dtos;

import java.util.UUID;

public record EmployeeRecordDto(UUID id,
                                String nome,
                                String setor) {
}
