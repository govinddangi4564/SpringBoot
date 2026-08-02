package com.work.springSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.work.springSecurity.entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {

}
