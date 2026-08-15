package com.example.jwtEmailWork.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.jwtEmailWork.entity.Products;
import com.example.jwtEmailWork.repository.ProductsRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {

	private ProductsRepository repo;
	private Cloudinary cloudinary;

	public List<Products> getAll() {
		return repo.findAll();
	}

	public Products createProduct(Products pr, MultipartFile file) {

		if (file == null || file.isEmpty()) {
			throw new RuntimeException("File is required");
		}

		try {
			Map<?, ?> uploadResult = cloudinary.uploader().upload(file.getBytes(),
					ObjectUtils.asMap("resource_type", "auto"));

			pr.setUrl(uploadResult.get("secure_url").toString());
			pr.setPublicId(uploadResult.get("public_id").toString());
			pr.setResourceType(uploadResult.get("resource_type").toString());

			return repo.save(pr);

		} catch (IOException e) {
			throw new RuntimeException("Failed to upload file to Cloudinary", e);
		}
	}

	public Products viewById(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
	}

	public Products updateProduct(Long id, Products pr, MultipartFile file) {

		Products product = repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

		try {

			// Store old Cloudinary details
			String oldPublicId = product.getPublicId();
			String oldResourceType = product.getResourceType();

			// Upload new file
			Map<?, ?> upload = cloudinary.uploader().upload(file.getBytes(),
					ObjectUtils.asMap("resource_type", "auto"));

			String url = upload.get("secure_url").toString();
			String publicId = upload.get("public_id").toString();
			String resourceType = upload.get("resource_type").toString();

			// Update product details
			product.setName(pr.getName());
			product.setDescription(pr.getDescription());
			product.setStockQuantity(pr.getStockQuantity());

			product.setUrl(url);
			product.setPublicId(publicId);
			product.setResourceType(resourceType);

			// Save updated product
			Products updatedProduct = repo.save(product);

			// Delete old Cloudinary file
			if (oldPublicId != null && oldResourceType != null) {
				cloudinary.uploader().destroy(oldPublicId, ObjectUtils.asMap("resource_type", oldResourceType));
			}

			return updatedProduct;

		} catch (IOException e) {
			throw new RuntimeException("Failed to update product", e);
		}
	}

	public String deleteProduct(Long id) {
		Products product = repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

		try {
			cloudinary.uploader().destroy(product.getPublicId(),
					ObjectUtils.asMap("resource_type", product.getResourceType()));
			repo.delete(product);

			return "Deleted Successfully";
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	public String downloadFile(Long id) {
		Products product = repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

		return product.getUrl().replace("/upload/", "upload/f1_attachment:" + product.getName() + "/");
	}

}
