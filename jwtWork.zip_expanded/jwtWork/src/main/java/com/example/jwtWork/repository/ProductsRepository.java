package com.example.jwtWork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jwtWork.entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

}