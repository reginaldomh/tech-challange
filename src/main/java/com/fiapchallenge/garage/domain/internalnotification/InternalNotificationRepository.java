package com.fiapchallenge.garage.domain.internalnotification;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface InternalNotificationRepository {

    InternalNotification save(InternalNotification internalNotification);

    boolean exists(UUID id);

    Optional<InternalNotification> findById(UUID id);

    Page<InternalNotification> findAll(Pageable pageable);
}