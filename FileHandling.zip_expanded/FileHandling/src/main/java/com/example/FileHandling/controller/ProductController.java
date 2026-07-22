package com.example.FileHandling.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.FileHandling.entity.Products;
import com.example.FileHandling.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {
	private ProductService service;

	@PostMapping
	public Products CreateProduct(@RequestParam String name, @RequestParam("file") MultipartFile file) {
		return service.createProduct(name, file);
	}

}
