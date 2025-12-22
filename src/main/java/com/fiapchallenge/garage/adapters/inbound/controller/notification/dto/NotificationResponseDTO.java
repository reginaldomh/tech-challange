package com.fiapchallenge.garage.adapters.inbound.controller.notification.dto;

import com.fiapchallenge.garage.domain.notification.Notification;

import java.time.LocalDateTime;
import java.util.UUID;

public record NotificationResponseDTO(
        UUID id,
        String type,
        String message,
        boolean read,
        LocalDateTime createdAt
) {
    public static NotificationResponseDTO fromDomain(Notification notification) {
        return new NotificationResponseDTO(
                notification.getId(),
                notification.getType(),
                notification.getMessage(),
                notification.isRead(),
                notification.getCreatedAt()
        );
    }
}