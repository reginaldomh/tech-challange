package com.fiapchallenge.garage.application.customer;

import com.fiapchallenge.garage.adapters.outbound.repositories.CustomerRepositoryImpl;
import com.fiapchallenge.garage.domain.customer.Customer;
import com.fiapchallenge.garage.domain.customer.command.CreateCustomerCommand;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreateCustomerService implements CreateCustomerUseCase {

    private final CustomerRepositoryImpl customerRepository;

    public CreateCustomerService(CustomerRepositoryImpl customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer create(CreateCustomerCommand data) {
        Customer customer = new Customer(data);
        customer = customerRepository.save(customer);

        return customer;
    }
}
