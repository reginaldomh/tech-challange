package com.fiapchallenge.garage.adapters.outbound.entities;

import com.fiapchallenge.garage.domain.quote.Quote;
import com.fiapchallenge.garage.domain.quote.QuoteStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Table(name = "quote")
@Entity
public class QuoteEntity {

    @Id
    @GeneratedValue
    private UUID id;
    
    @Column(name = "customer_id")
    private UUID customerId;
    
    @Column(name = "service_order_id")
    private UUID serviceOrderId;
    
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    
    @Enumerated(EnumType.STRING)
    private QuoteStatus status;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "quote", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<QuoteItemEntity> items;

    public QuoteEntity() {
    }

    public QuoteEntity(Quote quote) {
        this.id = quote.getId();
        this.customerId = quote.getCustomerId();
        this.serviceOrderId = quote.getServiceOrderId();
        this.totalAmount = quote.getTotalAmount();
        this.status = quote.getStatus();
        this.createdAt = quote.getCreatedAt();
    }

    public UUID getId() {
        return id;
    }

    public QuoteEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public QuoteEntity setCustomerId(UUID customerId) {
        this.customerId = customerId;
        return this;
    }

    public UUID getServiceOrderId() {
        return serviceOrderId;
    }

    public QuoteEntity setServiceOrderId(UUID serviceOrderId) {
        this.serviceOrderId = serviceOrderId;
        return this;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public QuoteEntity setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public QuoteStatus getStatus() {
        return status;
    }

    public QuoteEntity setStatus(QuoteStatus status) {
        this.status = status;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public QuoteEntity setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public List<QuoteItemEntity> getItems() {
        return items;
    }

    public QuoteEntity setItems(List<QuoteItemEntity> items) {
        this.items = items;
        return this;
    }
}