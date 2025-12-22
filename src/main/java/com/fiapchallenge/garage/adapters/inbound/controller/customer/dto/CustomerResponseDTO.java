package com.fiapchallenge.garage.adapters.inbound.controller.customer.dto;

import com.fiapchallenge.garage.domain.customer.Customer;

import java.util.UUID;

public record CustomerResponseDTO(
        UUID id,
        String name,
        String email,
        String phone,
        String cpfCnpj
) {
    public static CustomerResponseDTO fromDomain(Customer customer) {
        return new CustomerResponseDTO(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getCpfCnpjValue()
        );
    }
}