package com.example.MyWork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MyWork.dto.StudentUpdateRequest;
import com.example.MyWork.entity.Student;
import com.example.MyWork.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;

	// INSERT
	public Student save(Student st) {
		return studentRepo.save(st);
	}

	// READ
	public List<Student> readAll() {
		return studentRepo.findAll();
	}

	// READ by Id
	public Student getOne(Long id) {
		return studentRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
	}

	// UPDATE
	public Student updateStudent(Long id, StudentUpdateRequest studentDto) {
		Student student = studentRepo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
		student.setName(studentDto.getName());
		student.setPhone(studentDto.getPhone());
		return studentRepo.save(student);
	}

	// DELETE
	public void deleteStudent(Long id) {
		Student st = studentRepo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
		studentRepo.delete(st);
	}
}
