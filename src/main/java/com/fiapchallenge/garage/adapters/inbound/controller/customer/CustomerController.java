package com.fiapchallenge.garage.adapters.inbound.controller.customer;

import com.fiapchallenge.garage.application.commands.customer.CustomerFilterCmd;
import com.fiapchallenge.garage.application.commands.customer.UpdateCustomerCmd;
import com.fiapchallenge.garage.application.customer.CreateCustomerUseCase;
import com.fiapchallenge.garage.application.customer.ListCustomersService;
import com.fiapchallenge.garage.application.customer.UpdateCustomerService;

import java.util.List;
import com.fiapchallenge.garage.domain.customer.Customer;
import com.fiapchallenge.garage.adapters.inbound.controller.customer.dto.CustomerRequestDTO;
import com.fiapchallenge.garage.adapters.inbound.controller.customer.dto.UpdateCustomerDTO;
import com.fiapchallenge.garage.domain.customer.command.CreateCustomerCommand;

import java.util.UUID;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController implements CustomerControllerOpenApiSpec {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final UpdateCustomerService updateCustomerService;
    private final ListCustomersService listCustomersService;

    public CustomerController(CreateCustomerUseCase createCustomerUseCase, UpdateCustomerService updateCustomerService, ListCustomersService listCustomersService) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.updateCustomerService = updateCustomerService;
        this.listCustomersService = listCustomersService;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Customer>> list(@RequestParam(required = false) String name, @RequestParam(required = false) String email, @RequestParam(required = false) String cpfCnpj) {
        CustomerFilterCmd filter = new CustomerFilterCmd(name, email, cpfCnpj);
        List<Customer> customers = listCustomersService.list(filter);
        return ResponseEntity.ok(customers);
    }

    @Override
    @PostMapping
    public ResponseEntity<Customer> create(@Valid @RequestBody CustomerRequestDTO customerRequestDTO) {
        CreateCustomerCommand command = new CreateCustomerCommand(
                customerRequestDTO.name(),
                customerRequestDTO.email(),
                customerRequestDTO.phone(),
                customerRequestDTO.cpfCnpj()
        );


        Customer customer = createCustomerUseCase.handle(command);
        return ResponseEntity.ok(customer);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable UUID id, @Valid @RequestBody UpdateCustomerDTO updateCustomerDTO) {
        UpdateCustomerCmd updateCustomerCmd = new UpdateCustomerCmd(
                updateCustomerDTO.name(),
                updateCustomerDTO.email(),
                updateCustomerDTO.phone(),
                updateCustomerDTO.cpfCnpj()
        );

        Customer customer = updateCustomerService.update(id, updateCustomerCmd);
        return ResponseEntity.ok(customer);
    }
}
