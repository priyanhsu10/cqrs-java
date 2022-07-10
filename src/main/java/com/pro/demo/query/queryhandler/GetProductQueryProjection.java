package com.pro.demo.query.queryhandler;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pro.demo.models.ProductGetModel;
import com.pro.demo.query.GetProductQuery;
import com.pro.demo.repositories.ProuductRepository;

@Component
public class GetProductQueryProjection {

    private final ProuductRepository prouductRepository;

    public GetProductQueryProjection(ProuductRepository prouductRepository) {
        this.prouductRepository = prouductRepository;
    }

    @QueryHandler
    public List<ProductGetModel> handle(GetProductQuery query) {

        return prouductRepository.findAll().stream().map(x -> {
            var data = new ProductGetModel();
            BeanUtils.copyProperties(x, data);
            return data;
        }).collect(Collectors.toList());
    }

}
