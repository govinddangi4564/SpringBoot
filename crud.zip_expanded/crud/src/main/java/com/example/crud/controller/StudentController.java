package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.entity.Student;
import com.example.crud.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/read")
	public List<Student> getAllStudent() {
		return service.readAll();
	}

	@GetMapping("/read/{id}")
	public Student getOneStudent(@PathVariable Long id) {
		return service.getOne(id);
	}

	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student st) {
		return service.insert(st);
	}

}
