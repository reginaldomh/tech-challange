package com.fiapchallenge.garage.utils;

import com.fiapchallenge.garage.application.customer.CreateCustomerUseCase;
import com.fiapchallenge.garage.domain.customer.Customer;
import com.fiapchallenge.garage.domain.customer.command.CreateCustomerCommand;

public class CustomerMockUtils {

    public static Customer createCustomer(CreateCustomerUseCase createCustomerUseCase) {
        CreateCustomerCommand command = new CreateCustomerCommand(
                "John Doe",
                "john@example.com",
                "123456789",
                "11144477735"
        );
        return createCustomerUseCase.handle(command);
    }

    public static Customer createCustomer(CreateCustomerUseCase createCustomerUseCase, String name, String email, String phone, String cpfCnpj) {
        CreateCustomerCommand command = new CreateCustomerCommand(name, email, phone, cpfCnpj);
        return createCustomerUseCase.handle(command);
    }
}