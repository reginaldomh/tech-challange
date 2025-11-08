package com.fiapchallenge.garage.application.serviceorder;

import com.fiapchallenge.garage.application.quote.GenerateQuoteUseCase;
import com.fiapchallenge.garage.application.serviceorder.command.FinishServiceOrderDiagnosticCommand;
import com.fiapchallenge.garage.domain.serviceorder.ServiceOrder;
import com.fiapchallenge.garage.domain.serviceorder.ServiceOrderRepository;
import com.fiapchallenge.garage.shared.service.BaseServiceOrderService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class FinishServiceOrderDiagnosticService extends BaseServiceOrderService implements FinishServiceOrderDiagnosticUseCase {

    private final GenerateQuoteUseCase generateQuoteUseCase;

    public FinishServiceOrderDiagnosticService(ServiceOrderRepository serviceOrderRepository, GenerateQuoteUseCase generateQuoteUseCase) {
        super(serviceOrderRepository);
        this.generateQuoteUseCase = generateQuoteUseCase;
    }

    @Override
    public ServiceOrder handle(FinishServiceOrderDiagnosticCommand command) {
        generateQuoteUseCase.handle(command.id());
        return executeServiceOrderOperation(command.id(), ServiceOrder::sendToApproval);
    }
}
