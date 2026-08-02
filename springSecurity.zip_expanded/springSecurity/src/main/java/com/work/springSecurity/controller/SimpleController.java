package com.work.springSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

	@GetMapping("/hello")
	public String helloApi() {
		return "Hello this is a simple api..";
	}
}