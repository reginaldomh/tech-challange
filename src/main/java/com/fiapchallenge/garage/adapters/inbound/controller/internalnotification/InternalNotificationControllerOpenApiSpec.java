package com.fiapchallenge.garage.adapters.inbound.controller.internalnotification;

import com.fiapchallenge.garage.adapters.inbound.controller.internalnotification.dto.InternalNotificationRequestDTO;
import com.fiapchallenge.garage.domain.internalnotification.InternalNotification;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Internal Notifications", description = "API para gerenciamento de notificações internas")
public interface InternalNotificationControllerOpenApiSpec {

    @Operation(summary = "Criar notificação interna", description = "Cria uma nova notificação interna no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notificação criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    ResponseEntity<InternalNotification> create(@Valid @RequestBody InternalNotificationRequestDTO requestDTO);

    @Operation(summary = "Listar notificações internas", description = "Lista notificações interna do sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Notificações listadas com sucesso"),
        @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    ResponseEntity<Page<InternalNotification>> list(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size);
}
