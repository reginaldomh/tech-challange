package com.fiapchallenge.garage.application.internalnotification.list;

import com.fiapchallenge.garage.domain.internalnotification.InternalNotification;
import com.fiapchallenge.garage.domain.internalnotification.InternalNotificationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ListInternalNotificationService implements ListInternalNotificationUseCase {

    private final InternalNotificationRepository internalNotificationRepository;

    public ListInternalNotificationService(InternalNotificationRepository internalNotificationRepository) {
        this.internalNotificationRepository = internalNotificationRepository;
    }

    @Override
    public Page<InternalNotification> handle(Pageable pageable) {
        return internalNotificationRepository.findAll(pageable);
    }
}