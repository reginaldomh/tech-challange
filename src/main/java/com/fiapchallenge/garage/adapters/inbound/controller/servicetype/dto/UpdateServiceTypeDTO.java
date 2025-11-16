package com.fiapchallenge.garage.adapters.inbound.controller.servicetype.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Schema(name = "UpdateServiceType", description = "Dados para atualização de um tipo de serviço")
public record UpdateServiceTypeDTO(
        @NotNull(message = "Necessário informar a descrição do serviço") String description,
        @NotNull(message = "Necessário informar o valor do serviço") BigDecimal value
) {
}