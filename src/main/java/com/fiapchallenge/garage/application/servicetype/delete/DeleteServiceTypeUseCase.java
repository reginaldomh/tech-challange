package com.fiapchallenge.garage.application.servicetype.delete;

import java.util.UUID;

public interface DeleteServiceTypeUseCase {

    void handle(DeleteServiceTypeCmd command);

    record DeleteServiceTypeCmd(UUID id) {}
}