package com.pro.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.demo.entities.Product;

@Repository
public interface ProuductRepository extends JpaRepository<Product, String> {

}
