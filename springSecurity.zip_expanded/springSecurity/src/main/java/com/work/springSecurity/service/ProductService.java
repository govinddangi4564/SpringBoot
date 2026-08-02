package com.work.springSecurity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.work.springSecurity.entity.Products;
import com.work.springSecurity.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository ProductsRepository;

	public List<Products> getAllProductss() {
		return ProductsRepository.findAll();
	}

	public Products getProductsById(Long id) {
		return ProductsRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Products not found with id: " + id));
	}

	public Products createProducts(Products Products) {
		return ProductsRepository.save(Products);
	}

	public Products updateProducts(Long id, Products ProductsDetails) {
		Products Products = getProductsById(id);
		Products.setName(ProductsDetails.getName());
		Products.setPrice(ProductsDetails.getPrice());
		Products.setStockQuantity(ProductsDetails.getStockQuantity());
		Products.setCategory(ProductsDetails.getCategory());
		return ProductsRepository.save(Products);
	}

	public void deleteProducts(Long id) {
		Products Products = getProductsById(id);
		ProductsRepository.delete(Products);
	}
}
