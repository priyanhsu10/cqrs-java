package com.pro.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    private String productId;
    private String name;
    private double price;
    private int qauntity;
}
