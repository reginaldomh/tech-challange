package com.fiapchallenge.garage.unit.serviceorder.util.factory;

import com.fiapchallenge.garage.application.serviceorder.command.CreateServiceOrderCommand;

import java.util.List;
import java.util.UUID;

public class ServiceOrderTestFactory {

    public final static String OBSERVATIONS = "Troca de óleo e filtro";

    public static CreateServiceOrderCommand createServiceOrderCommand(UUID vehicleId, List<UUID> serviceTypeIdList) {
        return new CreateServiceOrderCommand(
                OBSERVATIONS,
                vehicleId,
                serviceTypeIdList
        );
    }
}
