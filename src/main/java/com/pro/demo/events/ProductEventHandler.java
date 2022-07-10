package com.pro.demo.events;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pro.demo.entities.Product;
import com.pro.demo.repositories.ProuductRepository;

@Component
@ProcessingGroup("product")
public class ProductEventHandler {
    private ProuductRepository repository;

    public ProductEventHandler(ProuductRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public void on(ProductCreatedEvent createdEvent) {
        Product p = new Product();
        BeanUtils.copyProperties(createdEvent, p);
        repository.save(p);
    }
}
