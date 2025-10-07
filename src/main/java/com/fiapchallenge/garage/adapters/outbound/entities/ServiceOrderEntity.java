package com.fiapchallenge.garage.adapters.outbound.entities;

import com.fiapchallenge.garage.domain.serviceorder.ServiceOrder;
import com.fiapchallenge.garage.domain.serviceorder.ServiceOrderStatus;
import jakarta.persistence.*;

import java.util.UUID;

@Table(name = "service_order")
@Entity
public class ServiceOrderEntity {

    @Id
    @GeneratedValue
    private UUID id;
    private String description;

    @Enumerated(EnumType.STRING)
    private ServiceOrderStatus status;

    private UUID vehicleId;

    public ServiceOrderEntity() {
    }

    public ServiceOrderEntity(ServiceOrder serviceOrder) {
        this.description = serviceOrder.getDescription();
        this.status = serviceOrder.getStatus();
        this.vehicleId = serviceOrder.getVehicleId();
    }

    public UUID getId() {
        return id;
    }

    public ServiceOrderEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ServiceOrderEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public ServiceOrderStatus getStatus() {
        return status;
    }

    public ServiceOrderEntity setStatus(ServiceOrderStatus status) {
        this.status = status;
        return this;
    }

    public UUID getVehicleId() {
        return vehicleId;
    }

    public ServiceOrderEntity setVehicleId(UUID vehicleId) {
        this.vehicleId = vehicleId;
        return this;
    }
}
