package com.fiapchallenge.garage.adapters.inbound.controller.internalnotification.dto;

import com.fiapchallenge.garage.domain.internalnotification.NotificationType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Schema(name = "InternalNotificationRequest", description = "Dados para criação de uma notificação interna")
public record InternalNotificationRequestDTO(
        @NotNull(message = "Necessário informar o tipo da notificação") NotificationType type,
        @NotNull(message = "Necessário informar o tipo da notificação") UUID resourceId,
        @NotNull(message = "Necessário informar a mensagem") String message
) {}
