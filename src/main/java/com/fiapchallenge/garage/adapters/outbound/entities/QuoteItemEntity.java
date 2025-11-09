package com.fiapchallenge.garage.adapters.outbound.entities;

import com.fiapchallenge.garage.domain.quote.QuoteItem;
import com.fiapchallenge.garage.domain.quote.QuoteItemType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "quote_item")
@Entity
public class QuoteItemEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quote_id")
    private QuoteEntity quote;

    private String description;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private QuoteItemType type;

    public QuoteItemEntity() {
    }

    public QuoteItemEntity(QuoteItem quoteItem) {
        this.description = quoteItem.getDescription();
        this.unitPrice = quoteItem.getUnitPrice();
        this.quantity = quoteItem.getQuantity();
        this.type = quoteItem.getType();
    }

    public UUID getId() {
        return id;
    }

    public QuoteItemEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public QuoteEntity getQuote() {
        return quote;
    }

    public QuoteItemEntity setQuote(QuoteEntity quote) {
        this.quote = quote;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public QuoteItemEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public QuoteItemEntity setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public QuoteItemEntity setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public QuoteItemType getType() {
        return type;
    }

    public QuoteItemEntity setType(QuoteItemType type) {
        this.type = type;
        return this;
    }
}