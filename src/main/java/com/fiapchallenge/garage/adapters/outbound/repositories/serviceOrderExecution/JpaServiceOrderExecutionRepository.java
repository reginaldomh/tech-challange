package com.fiapchallenge.garage.adapters.outbound.repositories.serviceOrderExecution;

import com.fiapchallenge.garage.adapters.outbound.entities.ServiceOrderEntity;
import com.fiapchallenge.garage.adapters.outbound.entities.ServiceOrderExecutionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaServiceOrderExecutionRepository extends JpaRepository<ServiceOrderExecutionEntity, UUID> {
}
