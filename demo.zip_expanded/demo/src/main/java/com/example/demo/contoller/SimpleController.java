package com.example.demo.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // Springboot  ->  SimpleController  ->  rest api http api endpoints, jakson
public class SimpleController {

	@GetMapping("/hello")  // Rest api endpoint -> localhost:8080/helo -> Get
	public String hello() {
		return "Hello this is our first REST api";
	}
}
