package com.fiapchallenge.garage.adapters.inbound.controller.servicetype.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

@Schema(name = "ServiceTypeRequest", description = "Dados para criação de um tipo de Serviço")
public record ServiceTypeRequestDTO(
        @NotBlank(message = "Necessário informar a descricao do Serviço") String description,
        @NotNull(message = "Necessário informar o valor do Serviço")
        @Positive(message = "O valor do Serviço deve ser maior que zero") BigDecimal value
) {
}
