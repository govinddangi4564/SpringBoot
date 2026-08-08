package com.example.jwtWork.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.jwtWork.entity.Products;
import com.example.jwtWork.repository.ProductsRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {

	private ProductsRepository repo;

	public List<Products> getAll() {
		return repo.findAll();
	}

	public Products createProduct(Products pr) {
		return repo.save(pr);
	}
}
