package com.example.MyWork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyWork.dto.StudentDetailsShowResponse;
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
	public Page<Student> readAll(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return studentService.readAll(page, size);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getOne(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(studentService.getOne(id));
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

	@GetMapping("/search/email")
	public Student findByEmail(@RequestParam String email) {
		return studentService.findByEmail(email);
	}

	@GetMapping("/search")
	public List<Student> search(@RequestParam String query) {
		return studentService.search(query);
	}

	@GetMapping("/read")
	public List<StudentDetailsShowResponse> readSomeDetails() {
		return studentService.show();
	}

	@GetMapping("/sort")
	public List<Student> sortStudent(@RequestParam String field, @RequestParam String direction) {
		return studentService.sort(field, direction);
	}
	
	//===========================================================================================================
	
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
}
