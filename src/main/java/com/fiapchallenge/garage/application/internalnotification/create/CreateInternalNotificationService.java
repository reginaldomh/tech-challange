package com.fiapchallenge.garage.application.internalnotification.create;

import com.fiapchallenge.garage.domain.internalnotification.InternalNotification;
import com.fiapchallenge.garage.domain.internalnotification.InternalNotificationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreateInternalNotificationService implements CreateInternalNotificationUseCase {

    private final InternalNotificationRepository internalNotificationRepository;

    public CreateInternalNotificationService(InternalNotificationRepository internalNotificationRepository) {
        this.internalNotificationRepository = internalNotificationRepository;
    }

    @Override
    public InternalNotification handle(CreateInternalNotificationCommand command) {
        InternalNotification internalNotification = InternalNotification.fromType(command.type(), command.resourceId(), command.message());

        return internalNotificationRepository.save(internalNotification);
    }
}
