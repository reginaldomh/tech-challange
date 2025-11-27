package com.fiapchallenge.garage.application.servicetype.update;

import com.fiapchallenge.garage.domain.servicetype.ServiceType;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.UUID;

public interface UpdateServiceTypeUseCase {

    ServiceType handle(UpdateServiceTypeCmd command);

    @Schema(name = "UpdateServiceType", description = "Comando para atualizar um tipo de serviço")
    record UpdateServiceTypeCmd(
       UUID id,
       String description,
       BigDecimal value
    ) {}
}