package com.fiapchallenge.garage.adapters.inbound.controller.internalnotification;

import com.fiapchallenge.garage.adapters.inbound.controller.internalnotification.dto.InternalNotificationRequestDTO;
import com.fiapchallenge.garage.application.internalnotification.create.CreateInternalNotificationUseCase;
import com.fiapchallenge.garage.application.internalnotification.create.CreateInternalNotificationUseCase.CreateInternalNotificationCommand;
import com.fiapchallenge.garage.application.internalnotification.list.ListInternalNotificationUseCase;
import com.fiapchallenge.garage.domain.internalnotification.InternalNotification;
import com.fiapchallenge.garage.shared.pagination.CustomPageRequest;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/internal-notifications")
public class InternalNotificationController implements InternalNotificationControllerOpenApiSpec {

    private final CreateInternalNotificationUseCase createInternalNotificationUseCase;
    private final ListInternalNotificationUseCase listInternalNotificationUseCase;

    public InternalNotificationController(CreateInternalNotificationUseCase createInternalNotificationUseCase, ListInternalNotificationUseCase listInternalNotificationUseCase) {
        this.createInternalNotificationUseCase = createInternalNotificationUseCase;
        this.listInternalNotificationUseCase = listInternalNotificationUseCase;
    }

    @Override
    @GetMapping
    public ResponseEntity<Page<InternalNotification>> list(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) {
        Pageable pageable = CustomPageRequest.of(page, size);
        Page<InternalNotification> notifications = listInternalNotificationUseCase.handle(pageable);
        return ResponseEntity.ok(notifications);
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
