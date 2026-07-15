package com.example.crud.controller;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.entity.Student;
import com.example.crud.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

	@Autowired
	private StudentService service;

//	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

	@GetMapping
	public List<Student> getAllStudent() {

		log.info("Info");
		log.trace("Trace");
		log.warn("Warn");
		log.error("Error");
		log.debug("Debug");

		return service.readAll();
	}

	@GetMapping("/{id}")
	public Student getOneStudent(@PathVariable Long id) {
		return service.getOne(id);
	}

	@PostMapping
	public Student saveStudent(@RequestBody Student st) {
		return service.insert(st);
	}

	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Long id) {
		service.delete(id);
		return "delete successfully .. ";
	}

	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
		return service.updateStudent(id, student);
	}

}
