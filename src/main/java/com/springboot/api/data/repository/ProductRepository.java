package com.springboot.api.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.api.data.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
