package com.fiapchallenge.garage.adapters.outbound.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class ServiceOrderServiceTypeId implements Serializable {

    private UUID serviceOrderId;
    private UUID serviceTypeId;
}