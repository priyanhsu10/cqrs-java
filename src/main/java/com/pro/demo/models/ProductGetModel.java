package com.pro.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductGetModel {
    private String productId;
    private String name;
    private Double price;
    private int quantity;

}
