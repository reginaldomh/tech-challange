package com.fiapchallenge.garage.application.internalnotification.create;

import com.fiapchallenge.garage.domain.internalnotification.InternalNotification;
import com.fiapchallenge.garage.domain.internalnotification.NotificationType;

import java.util.UUID;

public interface CreateInternalNotificationUseCase {

    InternalNotification handle(CreateInternalNotificationCommand command);

    record CreateInternalNotificationCommand(
            NotificationType type,
            UUID resourceId,
            String message
    ) {}
}
