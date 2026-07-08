package com.example.paginationOrException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PaginationOrExceptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaginationOrExceptionApplication.class, args);
	}

}
