package com.example.jwtWork.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwtWork.entity.Products;
import com.example.jwtWork.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

	private ProductService service;

	@GetMapping
	public ResponseEntity<List<Products>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
	}

	@PostMapping
	public ResponseEntity<Products> createProduct(@RequestBody Products pr) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createProduct(pr));
	}

}
