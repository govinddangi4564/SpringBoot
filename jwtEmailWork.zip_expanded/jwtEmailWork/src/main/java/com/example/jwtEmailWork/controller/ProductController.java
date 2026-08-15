package com.example.jwtEmailWork.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.jwtEmailWork.entity.Products;
import com.example.jwtEmailWork.service.ProductService;

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
	public ResponseEntity<Products> createProduct(@RequestParam String name, @RequestParam String description,
			@RequestParam Integer stockQuantity, @RequestPart("file") MultipartFile file) {

		Products pr = new Products();
		pr.setName(name);
		pr.setDescription(description);
		pr.setStockQuantity(stockQuantity);

		return ResponseEntity.status(HttpStatus.CREATED).body(service.createProduct(pr, file));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Products> getById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.viewById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Products> update(@PathVariable Long id, @RequestParam String name,
			@RequestParam String description, @RequestParam Integer stockQuantity,
			@RequestPart("file") MultipartFile file) {

		Products pr = new Products();
		pr.setName(name);
		pr.setDescription(description);
		pr.setStockQuantity(stockQuantity);

		return ResponseEntity.status(HttpStatus.OK).body(service.updateProduct(id, pr, file));
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		return service.deleteProduct(id);
	}

	@GetMapping("/download/{id}")
	public ResponseEntity<Void> downloadFile(@PathVariable Long id) {
		String url = service.downloadFile(id);

		return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url)).build();
	}

}
