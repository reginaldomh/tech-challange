package com.fiapchallenge.garage.adapters.inbound.controller.internalnotification;

import com.fiapchallenge.garage.adapters.inbound.controller.internalnotification.dto.InternalNotificationRequestDTO;
import com.fiapchallenge.garage.application.internalnotification.CreateInternalNotificationUseCase;
import com.fiapchallenge.garage.application.internalnotification.command.CreateInternalNotificationCommand;
import com.fiapchallenge.garage.domain.internalnotification.InternalNotification;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/internal-notifications")
public class InternalNotificationController implements InternalNotificationControllerOpenApiSpec {

    private final CreateInternalNotificationUseCase createInternalNotificationUseCase;

    public InternalNotificationController(CreateInternalNotificationUseCase createInternalNotificationUseCase) {
        this.createInternalNotificationUseCase = createInternalNotificationUseCase;
    }

    @Override
    @PostMapping
    public ResponseEntity<InternalNotification> create(@Valid @RequestBody InternalNotificationRequestDTO requestDTO) {
        CreateInternalNotificationCommand command = new CreateInternalNotificationCommand(
                requestDTO.type(),
                requestDTO.resourceId(),
                requestDTO.message()
        );

        InternalNotification notification = createInternalNotificationUseCase.handle(command);
        return ResponseEntity.ok(notification);
    }
}
