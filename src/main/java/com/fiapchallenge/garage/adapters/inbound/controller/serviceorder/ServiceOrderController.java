package com.fiapchallenge.garage.adapters.inbound.controller.serviceorder;

import com.fiapchallenge.garage.application.service.ServiceOrderService;
import com.fiapchallenge.garage.domain.serviceorder.ServiceOrder;
import com.fiapchallenge.garage.domain.serviceorder.ServiceOrderRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-orders")
public class ServiceOrderController implements ServiceOrderOpenApiSpec {

    private final ServiceOrderService serviceOrderService;

    public ServiceOrderController(ServiceOrderService serviceOrderService) {
        this.serviceOrderService = serviceOrderService;
    }

    @Override
    @PostMapping
    public ResponseEntity<ServiceOrder> create(@Valid @RequestBody ServiceOrderRequestDTO serviceOrderRequestDTO) {
        ServiceOrder serviceOrder = serviceOrderService.create(serviceOrderRequestDTO);
        return ResponseEntity.ok(serviceOrder);
    }
}
