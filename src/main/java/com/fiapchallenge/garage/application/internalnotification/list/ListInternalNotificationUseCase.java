package com.fiapchallenge.garage.application.internalnotification.list;

import com.fiapchallenge.garage.domain.internalnotification.InternalNotification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ListInternalNotificationUseCase {

    Page<InternalNotification> handle(Pageable pageable);
}