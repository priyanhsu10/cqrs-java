package com.pro.demo.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreatedEvent {
    private String productId;
    private String name;
    private double price;
    private int qauntity;
    public Object var;
}
