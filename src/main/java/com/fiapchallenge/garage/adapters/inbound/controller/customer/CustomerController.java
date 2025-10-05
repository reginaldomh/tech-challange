package com.fiapchallenge.garage.adapters.inbound.controller.customer;

import com.fiapchallenge.garage.application.commands.customer.CreateCustomerCmd;
import com.fiapchallenge.garage.application.service.CustomerService;
import com.fiapchallenge.garage.domain.customer.Customer;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController implements CustomerControllerOpenApiSpec {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    @PostMapping
    public ResponseEntity<Customer> create(@Valid @RequestBody CreateCustomerCmd createCustomerCmd) {
        Customer customer = customerService.create(createCustomerCmd);
        return ResponseEntity.ok(customer);
    }
}
