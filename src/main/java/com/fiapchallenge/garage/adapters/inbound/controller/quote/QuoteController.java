package com.fiapchallenge.garage.adapters.inbound.controller.quote;

import com.fiapchallenge.garage.application.quote.GenerateQuoteService;
import com.fiapchallenge.garage.application.quote.ApproveQuoteService;
import com.fiapchallenge.garage.application.quote.RejectQuoteService;
import com.fiapchallenge.garage.domain.quote.Quote;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/quotes")
@Tag(name = "Quote", description = "Quote management API")
public class QuoteController {
    private final GenerateQuoteService generateQuoteService;
    private final ApproveQuoteService approveQuoteService;
    private final RejectQuoteService rejectQuoteService;

    public QuoteController(GenerateQuoteService generateQuoteService, ApproveQuoteService approveQuoteService, RejectQuoteService rejectQuoteService) {
        this.generateQuoteService = generateQuoteService;
        this.approveQuoteService = approveQuoteService;
        this.rejectQuoteService = rejectQuoteService;
    }

    @Operation(summary = "Gerar orçamento", description = "Gera orçamento detalhado para uma ordem de serviço")
    @GetMapping("/service-order/{serviceOrderId}")
    public ResponseEntity<Quote> generateQuote(@PathVariable UUID serviceOrderId) {
        Quote quote = generateQuoteService.handle(serviceOrderId);
        return ResponseEntity.ok(quote);
    }

    @Operation(summary = "Aprovar orçamento", description = "Aprova o orçamento de uma ordem de serviço")
    @PostMapping("/service-order/{serviceOrderId}/approve")
    public ResponseEntity<Quote> approveQuote(@PathVariable UUID serviceOrderId) {
        Quote quote = approveQuoteService.handle(serviceOrderId);
        return ResponseEntity.ok(quote);
    }

    @Operation(summary = "Rejeitar orçamento", description = "Rejeita o orçamento de uma ordem de serviço")
    @PostMapping("/service-order/{serviceOrderId}/reject")
    public ResponseEntity<Quote> rejectQuote(@PathVariable UUID serviceOrderId) {
        Quote quote = rejectQuoteService.handle(serviceOrderId);
        return ResponseEntity.ok(quote);
    }
}
