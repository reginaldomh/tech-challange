package com.fiapchallenge.garage.domain.customer;

import jakarta.validation.constraints.NotNull;

public record CustomerRequestDTO(
        @NotNull(message = "Necessário informar o nome do cliente") String name,
        @NotNull(message = "Necessário informar o email do cliente") String email,
        @NotNull(message = "Necessário informar o telefone do cliente") String phone
) {
}
