package com.example.jwtEmailWork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jwtEmailWork.entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

}