package com.fiapchallenge.garage.unit.serviceorder.utils.factory;

import com.fiapchallenge.garage.domain.serviceorder.ServiceOrder;
import com.fiapchallenge.garage.domain.serviceorder.ServiceOrderRequestDTO;
import com.fiapchallenge.garage.domain.serviceorder.ServiceOrderStatus;

import java.util.UUID;

public class ServiceOrderTestFactory {

    public static final UUID ID = UUID.randomUUID();
    public static final UUID VEHICLE_ID = UUID.randomUUID();
    public static final String DESCRIPTION = "Trcola de óleo";
    public static final ServiceOrderStatus STATUS = ServiceOrderStatus.CREATED;

    public static ServiceOrder build() {
        return new ServiceOrder(ID, VEHICLE_ID, DESCRIPTION, STATUS);
    }

    public static ServiceOrderRequestDTO buildRequestDTO() {
        return new ServiceOrderRequestDTO(DESCRIPTION, VEHICLE_ID);
    }
}
