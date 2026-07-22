package com.example.FileHandling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FileHandling.entity.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {

}
