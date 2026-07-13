package com.example.Schedular.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/work")
public class SimpleRestController {
	
	@GetMapping
	public String simpleApp() {
		return "Hello I am a simple api..";
	}
}
