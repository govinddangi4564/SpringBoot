package com.example.FileHandling.controller;

import java.net.URI;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping
	public List<Products> viewAll() {
		return service.viewAll();
	}

	@GetMapping("/{id}")
	public Products viewById(@PathVariable Long id) {
		return service.viewById(id);
	}

	@PutMapping("/{id}")
	public Products update(@PathVariable Long id, @RequestParam String name, @RequestParam MultipartFile file) {
		return service.updateProduct(id, name, file);
	}

	@DeleteMapping("{id}")
	public String delete(@PathVariable Long id) {
		return service.deleteProduct(id);
	}

//	@GetMapping("/download")
//	public ResponseEntity<Resource> downloadFile(@RequestParam String filename) {
//		Resource resource = service.downloadFile(filename);
//		return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM)
//				// This header triggers the "Save As" dialog in the browser
//				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//				.body(resource);
//
//	}

	@GetMapping("/download/{id}")
	public ResponseEntity<Void> downloadFile(@PathVariable Long id) {
		String url = service.downloadFile(id);

		return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url)).build();
	}

}
