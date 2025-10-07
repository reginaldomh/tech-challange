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

    public ServiceOrder(UUID id, UUID vehicleId, String description, ServiceOrderStatus status) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.description = description;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public UUID getVehicleId() {
        return vehicleId;
    }

    public String getDescription() {
        return description;
    }

    public ServiceOrderStatus getStatus() {
        return status;
    }
}
