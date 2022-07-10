package com.pro.demo.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCommand {
    @TargetAggregateIdentifier
    private String productId;
    private String name;
    private double price;
    private int qauntity;
}
