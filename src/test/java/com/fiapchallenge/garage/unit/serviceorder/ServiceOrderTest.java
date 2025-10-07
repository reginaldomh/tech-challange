package com.fiapchallenge.garage.unit.serviceorder;

import com.fiapchallenge.garage.adapters.outbound.repositories.serviceorder.ServiceOrderRepositoryImpl;
import com.fiapchallenge.garage.application.service.ServiceOrderService;
import com.fiapchallenge.garage.domain.serviceorder.ServiceOrder;
import com.fiapchallenge.garage.unit.serviceorder.utils.factory.ServiceOrderTestFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceOrderTest {

    @Mock
    private ServiceOrderRepositoryImpl serviceOrderRepository;

    @InjectMocks
    private ServiceOrderService serviceOrderService;

    @Test
    @DisplayName("Criar ordem de serviço")
    void shouldCreateServiceOrder() {
        when(serviceOrderRepository.save(any(ServiceOrder.class))).thenReturn(ServiceOrderTestFactory.build());

        ServiceOrder serviceOrder = serviceOrderService.create(ServiceOrderTestFactory.buildRequestDTO());

        assertNotNull(serviceOrder);
        assertEquals(ServiceOrderTestFactory.ID, serviceOrder.getId());
        assertEquals(ServiceOrderTestFactory.VEHICLE_ID, serviceOrder.getVehicleId());
        assertEquals(ServiceOrderTestFactory.DESCRIPTION, serviceOrder.getDescription());
        assertEquals(ServiceOrderTestFactory.STATUS, serviceOrder.getStatus());
    }
}
