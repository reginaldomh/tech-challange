package com.fiapchallenge.garage.application.servicetype;

import com.fiapchallenge.garage.application.servicetype.command.CreateServiceTypeCommand;
import com.fiapchallenge.garage.domain.servicetype.ServiceType;

public interface CreateServiceTypeUseCase {

    ServiceType handle(CreateServiceTypeCommand command);
}
