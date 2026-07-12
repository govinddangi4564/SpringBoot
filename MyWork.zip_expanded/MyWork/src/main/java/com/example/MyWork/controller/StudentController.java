package com.example.MyWork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyWork.dto.StudentUpdateRequest;
import com.example.MyWork.entity.Student;
import com.example.MyWork.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping
	public Student save(@RequestBody Student st) {
		return studentService.save(st);
	}

	@GetMapping
	public List<Student> readAll() {
		return studentService.readAll();
	}

	@GetMapping("/{id}")
	public Student getOne(@PathVariable Long id) {
		return studentService.getOne(id);
	}

	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody StudentUpdateRequest dto) {
		return studentService.updateStudent(id, dto);
	}

	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "Delete Successfully";
	}
}
