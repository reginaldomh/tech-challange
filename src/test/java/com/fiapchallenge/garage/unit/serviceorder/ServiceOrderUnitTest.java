package com.fiapchallenge.garage.unit.serviceorder;

import com.fiapchallenge.garage.application.serviceorder.CreateServiceOrderService;
import com.fiapchallenge.garage.domain.customer.CustomerRepository;
import com.fiapchallenge.garage.domain.serviceorder.ServiceOrder;
import com.fiapchallenge.garage.domain.serviceorder.ServiceOrderStatus;
import com.fiapchallenge.garage.domain.servicetype.ServiceType;
import com.fiapchallenge.garage.domain.servicetype.ServiceTypeRepository;
import com.fiapchallenge.garage.unit.serviceorder.util.factory.ServiceOrderTestFactory;
import com.fiapchallenge.garage.unit.servicetype.utils.factory.ServiceTypeTestFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceOrderUnitTest {

    @Mock
    ServiceTypeRepository serviceTypeRepository;

    @InjectMocks
    private CreateServiceOrderService createServiceOrderService;

    @Test
    @DisplayName("Criação de Ordem de Serviço")
    void shouldCreateServiceOrder() {
        // Arrange
        ServiceType serviceType = ServiceTypeTestFactory.build();
        when(serviceTypeRepository.findByIdOrThrow(any(UUID.class))).thenReturn(serviceType);
        UUID vehicleId = UUID.randomUUID();
        List<UUID> serviceOrderTypeIdList = List.of(serviceType.getId());

        // Act
        ServiceOrder serviceOrder = createServiceOrderService.handle(ServiceOrderTestFactory.createServiceOrderCommand(vehicleId, serviceOrderTypeIdList));

        // Assert
        assertEquals(ServiceOrderTestFactory.OBSERVATIONS, serviceOrder.getObservations());
        assertEquals(ServiceOrderStatus.CREATED, serviceOrder.getStatus());
        assertEquals(vehicleId, serviceOrder.getVehicleId());
        assertEquals(serviceOrderTypeIdList.size(), serviceOrder.getServiceTypeList().size());
        assertEquals(serviceOrderTypeIdList, serviceOrder.getServiceTypeListIds());
    }
}
