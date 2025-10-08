package com.fiapchallenge.garage.application.customer;

import com.fiapchallenge.garage.application.commands.customer.CustomerFilterCmd;
import com.fiapchallenge.garage.domain.customer.Customer;
import com.fiapchallenge.garage.domain.customer.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ListCustomersService {

    private final CustomerRepository customerRepository;

    public ListCustomersService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> list() {
        return customerRepository.findAll();
    }

    public List<Customer> list(CustomerFilterCmd filter) {
        if (!filter.hasFilters()) {
            return customerRepository.findAll();
        }

        return customerRepository.findByFilters(filter.name(), filter.email(), filter.cpfCnpj());
    }
}
