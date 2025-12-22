package com.fiapchallenge.garage.adapters.inbound.controller.serviceorder.dto;

import com.fiapchallenge.garage.domain.servicetype.ServiceType;

import java.math.BigDecimal;
import java.util.UUID;

public record ServiceTypeDTO(
        UUID id,
        String description,
        BigDecimal value
) {
    public static ServiceTypeDTO fromDomain(ServiceType serviceType) {
        return new ServiceTypeDTO(
                serviceType.getId(),
                serviceType.getDescription(),
                serviceType.getValue()
        );
    }
}