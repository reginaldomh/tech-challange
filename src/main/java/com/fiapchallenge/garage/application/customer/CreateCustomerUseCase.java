package com.fiapchallenge.garage.application.customer;

import com.fiapchallenge.garage.domain.customer.Customer;
import com.fiapchallenge.garage.domain.customer.CustomerRequestDTO;

public interface CreateCustomerUseCase {

    Customer create(CustomerRequestDTO customerRequestDTO);
}
