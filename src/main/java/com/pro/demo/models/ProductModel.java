package com.pro.demo.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductModel {
    private String name;
    private Double price;
    private int quantity;

}
