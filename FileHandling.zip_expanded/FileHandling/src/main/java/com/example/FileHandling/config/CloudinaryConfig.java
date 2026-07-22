package com.example.FileHandling.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloudinaryConfig {
	
	private final String cloudName = "your_cloud_name";
	private final String api_key = "your_api_key";
	private final String api_secret = "your_api_secret";
	
	@Bean
	public Cloudinary getCloud() {
		return new Cloudinary(
				ObjectUtils.asMap(
						"cloud_name", cloudName, 
						"api_key", api_key, 
						"api_secret",api_secret
					));
	}
}