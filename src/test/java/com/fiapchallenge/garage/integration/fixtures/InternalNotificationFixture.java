package com.fiapchallenge.garage.integration.fixtures;

import com.fiapchallenge.garage.application.internalnotification.create.CreateInternalNotificationService;
import com.fiapchallenge.garage.application.internalnotification.create.CreateInternalNotificationUseCase;
import com.fiapchallenge.garage.domain.internalnotification.InternalNotification;
import com.fiapchallenge.garage.domain.internalnotification.NotificationType;

import java.util.UUID;

public class InternalNotificationFixture {

    public static InternalNotification createNotification(CreateInternalNotificationService createInternalNotificationService, NotificationType type, String message) {
        CreateInternalNotificationUseCase.CreateInternalNotificationCommand command = new CreateInternalNotificationUseCase.CreateInternalNotificationCommand(type, UUID.randomUUID(), message);

        return createInternalNotificationService.handle(command);
    }
}
