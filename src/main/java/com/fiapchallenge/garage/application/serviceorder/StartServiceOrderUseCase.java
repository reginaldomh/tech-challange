package com.fiapchallenge.garage.application.serviceorder;

import com.fiapchallenge.garage.application.serviceorder.command.StartServiceOrderCommand;
import com.fiapchallenge.garage.domain.serviceorder.ServiceOrder;

public interface StartServiceOrderUseCase {

    ServiceOrder handle(StartServiceOrderCommand command);
}
