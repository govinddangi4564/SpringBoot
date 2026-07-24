package com.example.FileHandling.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.FileHandling.entity.Products;
import com.example.FileHandling.repository.ProductsRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {

	private ProductsRepository repo;
	private Cloudinary cloudinary;

//	public Products createProduct(String name, MultipartFile file) {
//		String uploadDir = "C:\\spring_boot_7_8\\imageWork.zip_expanded\\imageWork\\products";
//
//		String filename = file.getOriginalFilename();  // apple.png
//		String path = uploadDir + File.separator + filename; 
//			// C:\\spring_boot_7_8\\imageWork.zip_expanded\\imageWork\\products\\apple.png
//
//		try {
//			file.transferTo(new File(path)); 
//		} catch (IllegalStateException | IOException e) {
//			e.printStackTrace();
//		}
//
//		Products pr = new Products();
//		pr.setName(name);
//		pr.setUrl(path);
//		return repo.save(pr);
//	}

//	public Resource downloadFile(String filename) {
//
//		String folder = "D:\\All Codes\\Spring_Boot\\FileHandling.zip_expanded\\FileHandling\\Files";
//		Path pt = Path.of(folder + File.separator + filename);
//
//		Resource res = null;
//		try {
//			res = new UrlResource(pt.toUri());
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}
//
//		return res;
//	}

	// Download
	public String downloadFile(Long id) {
		Products product = repo.findById(id).orElseThrow(() -> new RuntimeException("Product Not Found"));

		return product.getUrl().replace("/upload/", "/upload/fl_attachment:" + product.getName() + "/");
	}

	// Upload
	public Products createProduct(String name, MultipartFile file) {
		// "auto" detects if it's an image, video, or audio automatically
		Map<?, ?> uploadResult = null;
		try {
			uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("resource_type", "auto"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 2. Extract the URL
		String url = uploadResult.get("secure_url").toString();
		String publicId = uploadResult.get("public_id").toString();
		String resourceType = uploadResult.get("resource_type").toString();

		Products pr = new Products();
		pr.setName(name);
		pr.setUrl(url);
		pr.setPublicId(publicId);
		pr.setResourceType(resourceType);

		return repo.save(pr);
	}

	// View
	public List<Products> viewAll() {
		return repo.findAll();
	}

	// View by id
	public Products viewById(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
	}

	// Update
	public Products updateProduct(Long id, String name, MultipartFile file) {
		Products product = repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

		try {
			// Delete old file from Cloudinary
			cloudinary.uploader().destroy(product.getPublicId(),
					ObjectUtils.asMap("resource_type", product.getResourceType()));

			// Upload new file
			Map<?, ?> upload = cloudinary.uploader().upload(file.getBytes(),
					ObjectUtils.asMap("resource_type", "auto"));

			String url = upload.get("secure_url").toString();
			String publicId = upload.get("public_id").toString();
			String resourceType = upload.get("resource_type").toString();

			product.setName(name);
			product.setUrl(url);
			product.setPublicId(publicId);
			product.setResourceType(resourceType);

			return repo.save(product);

		} catch (IOException e) {
			throw new RuntimeException("Failed to update product", e);
		}
	}

	// Delete
	public String deleteProduct(Long id) {
		Products product = repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

		try {
			cloudinary.uploader().destroy(product.getPublicId(),
					ObjectUtils.asMap("resource_type", product.getResourceType()));
			repo.delete(product);

			return "Deleted Successfully";

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
