package com.example.FileHandling.service;

import java.io.IOException;
import java.util.Map;

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

	public Products createProduct(String name, MultipartFile file) {
		// "auto" detects if it's an image, video, or audio automatically
		Map uploadResult = null;
		try {
			uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("resource_type", "auto"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 2. Extract the URL
		String url = uploadResult.get("url").toString();

		Products pr = new Products();
		pr.setName(name);
		pr.setUrl(url);

		return repo.save(pr);
	}
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

}
