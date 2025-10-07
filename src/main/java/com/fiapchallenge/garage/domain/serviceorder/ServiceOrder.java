package com.fiapchallenge.garage.domain.serviceorder;

import java.util.UUID;

public class ServiceOrder {

    private UUID id;
    private UUID vehicleId;
    private String description;
    private ServiceOrderStatus status;

    public ServiceOrder(ServiceOrderRequestDTO serviceOrderRequestDTO) {
        this.vehicleId = serviceOrderRequestDTO.vehicleId();
        this.description = serviceOrderRequestDTO.description();
        this.status = ServiceOrderStatus.CREATED;
    }
}
