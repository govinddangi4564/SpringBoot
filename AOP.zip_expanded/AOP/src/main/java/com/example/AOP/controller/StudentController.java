package com.example.AOP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AOP.entity.Student;
import com.example.AOP.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping
	public List<Student> readAll() {
		return service.readAll();
	}

	public Student getOne(@PathVariable Long id) {
		return service.getOne(id);
	}

}
