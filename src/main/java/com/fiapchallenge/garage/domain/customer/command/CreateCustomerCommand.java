package com.fiapchallenge.garage.domain.customer.command;

import com.fiapchallenge.garage.application.validation.CpfCnpj;
import jakarta.validation.constraints.NotNull;

public record CreateCustomerCommand(
        @NotNull String name,
        @NotNull String email,
        @NotNull String phone,
        @NotNull @CpfCnpj String cpfCnpj
) {
}
