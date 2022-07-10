package com.pro.demo.controller;

import java.util.List;
import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.demo.commands.CreateCommand;
import com.pro.demo.models.ProductGetModel;
import com.pro.demo.models.ProductModel;
import com.pro.demo.query.GetProductQuery;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    public ProductController(CommandGateway commandGateway, QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @PostMapping
    public String addProduct(@RequestBody ProductModel product) {

        var command = CreateCommand.builder().productId(UUID.randomUUID().toString())
                .name(product.getName())
                .price(product.getPrice())
                .qauntity(product.getQuantity())
                .build();

        String result = commandGateway.sendAndWait(command);
        return result;
    }

    @GetMapping
    public List<ProductGetModel> getProducts() {
        var getQuery = new GetProductQuery();
        var resutlt = queryGateway.query(getQuery,
                ResponseTypes.multipleInstancesOf(ProductGetModel.class));
        return resutlt.join();
    }

}
