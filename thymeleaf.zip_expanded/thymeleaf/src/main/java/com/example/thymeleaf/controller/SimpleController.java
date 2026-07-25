package com.example.thymeleaf.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.thymeleaf.entity.User;

@Controller // Cotroller for redirect to the html page, it is not rest api
@RequestMapping("/student")
public class SimpleController {
//	@GetMapping("/home")
//	public String home(Model model) {
//		model.addAttribute("name", "Govind");
//		return "home";
//	}

//	@GetMapping("/home")
//	public String home(Model model) {
//		User u = new User(101L, "Govind", "govinddangi580@gmail.com", "govind12");
//		model.addAttribute("user", u);
//		return "home";
//	}
	
	private List<User> u = List.of(
			new User(101L, "Govind", "govind@gmail.com", "govind12"),
			new User(102L, "sunil", "sunil@gmail.com", "sunil12"),
			new User(103L, "shyam", "shyam@gmail.com", "shyam12"),
			new User(104L, "gopal", "gopal@gmail.com", "gopal12"),
			new User(105L, "jay", "jay@gmail.com", "jay12"));
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("user", u);
		return "home";
	}
	
}
