package com.fiapchallenge.garage.application.service;

import com.fiapchallenge.garage.adapters.outbound.repositories.CustomerRepositoryImpl;
import com.fiapchallenge.garage.application.commands.customer.CreateCustomerCmd;
import com.fiapchallenge.garage.domain.customer.Customer;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepositoryImpl customerRepository;

    public CustomerService(CustomerRepositoryImpl customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer create(CreateCustomerCmd cmd) {
        Customer customer = new Customer(cmd.name(), cmd.email(), cmd.phone());
        customerRepository.save(customer);

        return customer;
    }
}
