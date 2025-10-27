package com.fiapchallenge.garage.application.quote;

import com.fiapchallenge.garage.application.quote.command.ApproveQuoteCommand;
import com.fiapchallenge.garage.application.serviceorder.StartServiceOrderUseCase;
import com.fiapchallenge.garage.application.serviceorder.command.StartServiceOrderCommand;
import com.fiapchallenge.garage.domain.quote.Quote;
import com.fiapchallenge.garage.domain.quote.QuoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ApproveQuoteService implements ApproveQuoteUseCase {

    private final QuoteRepository quoteRepository;
    private final StartServiceOrderUseCase approveServiceOrderUseCase;

    public ApproveQuoteService(QuoteRepository quoteRepository, StartServiceOrderUseCase approveServiceOrderUseCase) {
        this.quoteRepository = quoteRepository;
        this.approveServiceOrderUseCase = approveServiceOrderUseCase;
    }

    public Quote handle(ApproveQuoteCommand command) {
        Quote quote = quoteRepository.findById(command.id())
                .orElseThrow(() -> new IllegalArgumentException("Orçamento não encontrado"));

        StartServiceOrderCommand approveServiceOrderCommand = new StartServiceOrderCommand(quote.getServiceOrderId());
        approveServiceOrderUseCase.handle(approveServiceOrderCommand);

        return quote;
    }
}
