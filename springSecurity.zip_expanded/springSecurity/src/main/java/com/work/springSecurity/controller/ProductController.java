package com.work.springSecurity.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.work.springSecurity.entity.Products;
import com.work.springSecurity.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService ProductsService;

	// Accessible by USER and ADMIN
	@GetMapping
	public ResponseEntity<List<Products>> getAllProductss() {
		return ResponseEntity.ok(ProductsService.getAllProductss());
	}

	// Accessible by USER and ADMIN
	@GetMapping("/{id}")
	public ResponseEntity<Products> getProductsById(@PathVariable Long id) {
		return ResponseEntity.ok(ProductsService.getProductsById(id));
	}

	// Accessible ONLY by ADMIN
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Products> createProducts(@RequestBody Products Products) {
		return new ResponseEntity<>(ProductsService.createProducts(Products), HttpStatus.CREATED);
	}

	// Accessible ONLY by ADMIN
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Products> updateProducts(@PathVariable Long id, @RequestBody Products Products) {
		return ResponseEntity.ok(ProductsService.updateProducts(id, Products));
	}

	// Accessible ONLY by ADMIN
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteProducts(@PathVariable Long id) {
		ProductsService.deleteProducts(id);
		return ResponseEntity.ok("Products deleted successfully with id: " + id);
	}
}