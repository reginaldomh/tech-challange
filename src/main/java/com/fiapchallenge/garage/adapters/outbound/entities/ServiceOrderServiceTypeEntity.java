package com.fiapchallenge.garage.adapters.outbound.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "service_order_service_type")
public class ServiceOrderServiceTypeEntity {

    @EmbeddedId
    private ServiceOrderServiceTypeId id;

    private UUID serviceOrderId;
    private UUID serviceTypeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("serviceOrderId")
    @JoinColumn(name = "service_order_id", insertable = false, updatable = false)
    private ServiceOrderEntity serviceOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("serviceTypeId")
    @JoinColumn(name = "service_type_id", insertable = false, updatable = false)
    private ServiceTypeEntity serviceType;

    public ServiceOrderServiceTypeEntity() {
    }

    public ServiceOrderServiceTypeEntity(UUID serviceOrderId, UUID serviceTypeId) {
        this.serviceOrderId = serviceOrderId;
        this.serviceTypeId = serviceTypeId;
    }
}