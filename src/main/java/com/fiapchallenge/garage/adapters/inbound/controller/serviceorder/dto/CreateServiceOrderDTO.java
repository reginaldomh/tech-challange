package com.fiapchallenge.garage.adapters.inbound.controller.serviceorder.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record CreateServiceOrderDTO(
        String observations,
        @NotNull UUID vehicleId,
        @NotNull UUID customerId,
        List<UUID> serviceTypeIdList,
        @Valid List<StockItemDTO> stockItems
) {}
