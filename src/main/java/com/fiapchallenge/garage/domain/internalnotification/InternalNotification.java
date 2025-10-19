package com.fiapchallenge.garage.domain.internalnotification;

import java.time.LocalDateTime;
import java.util.UUID;

public class InternalNotification {

    private UUID id;
    private NotificationType type;
    private boolean acknowledged;
    private UUID userId;
    private LocalDateTime createdAt;
    private LocalDateTime acknowledgedAt;

    public InternalNotification() {
    }

    public InternalNotification(UUID id, NotificationType type, boolean acknowledged, UUID userId, LocalDateTime createdAt, LocalDateTime acknowledgedAt) {
        this.id = id;
        this.type = type;
        this.acknowledged = acknowledged;
        this.userId = userId;
        this.createdAt = createdAt;
        this.acknowledgedAt = acknowledgedAt;
    }

    public UUID getId() {
        return id;
    }

    public InternalNotification setId(UUID id) {
        this.id = id;
        return this;
    }

    public NotificationType getType() {
        return type;
    }

    public InternalNotification setType(NotificationType type) {
        this.type = type;
        return this;
    }

    public boolean isAcknowledged() {
        return acknowledged;
    }

    public InternalNotification setAcknowledged(boolean acknowledged) {
        this.acknowledged = acknowledged;
        return this;
    }

    public UUID getUserId() {
        return userId;
    }

    public InternalNotification setUserId(UUID userId) {
        this.userId = userId;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public InternalNotification setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDateTime getAcknowledgedAt() {
        return acknowledgedAt;
    }

    public InternalNotification setAcknowledgedAt(LocalDateTime acknowledgedAt) {
        this.acknowledgedAt = acknowledgedAt;
        return this;
    }
}