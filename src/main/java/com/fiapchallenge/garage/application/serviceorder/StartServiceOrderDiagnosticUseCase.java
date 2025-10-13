package com.fiapchallenge.garage.application.serviceorder;

import com.fiapchallenge.garage.application.serviceorder.command.StartServiceOrderDiagnosticCommand;

public interface StartServiceOrderDiagnosticUseCase {

    void handle(StartServiceOrderDiagnosticCommand command);
}
