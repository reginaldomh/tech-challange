package com.fiapchallenge.garage.adapters.outbound.repositories.customer;

import com.fiapchallenge.garage.adapters.outbound.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, UUID> {
}
