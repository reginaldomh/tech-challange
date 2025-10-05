package com.fiapchallenge.garage.adapters.inbound.controller.customer;

import com.fiapchallenge.garage.application.commands.customer.CreateCustomerCmd;
import com.fiapchallenge.garage.domain.customer.Customer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Customer", description = "Customer management API")
public interface CustomerControllerOpenApiSpec {

    @Operation(summary = "Criar um novo cliente", description = "Cria um novo cliente com os dados fornecidos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Customer criado com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class))),
        @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content)
    })
    @PostMapping(consumes = "application/json")
    ResponseEntity<Customer> create(
        @Parameter(name = "createCustomer", description = "Dados para criar cliente", schema = @Schema(implementation = CreateCustomerCmd.class))
        @Valid @RequestBody CreateCustomerCmd createCustomerCmd);
}
