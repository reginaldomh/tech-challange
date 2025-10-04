package com.fiapchallenge.garage.adapters.inbound.controller;

import com.fiapchallenge.garage.application.service.CustomerService;
import com.fiapchallenge.garage.domain.customer.Customer;
import com.fiapchallenge.garage.domain.customer.CustomerRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Customer> create(@Valid @ModelAttribute CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerService.create(customerRequestDTO);
        return ResponseEntity.ok(customer);
    }
}
