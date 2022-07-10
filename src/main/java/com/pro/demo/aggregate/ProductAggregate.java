package com.pro.demo.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.pro.demo.commands.CreateCommand;
import com.pro.demo.events.ProductCreatedEvent;

@Aggregate
public class ProductAggregate {
    @AggregateIdentifier
    private String productId;
    private String name;
    private double price;
    private int qauntity;

    @CommandHandler
    public ProductAggregate(CreateCommand command) {
        ProductCreatedEvent event = new ProductCreatedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    public ProductAggregate() {
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent createdEvent) {
        this.qauntity = createdEvent.getQauntity();
        this.name = createdEvent.getName();
        this.price = createdEvent.getPrice();
        this.productId = createdEvent.getProductId();

    }

}
