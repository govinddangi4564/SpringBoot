package com.example.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.entity.Student;
import com.example.crud.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repo;

	public List<Student> readAll() {
		return repo.findAll();
	}

	public Student getOne(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
	}

	public Student insert(Student st) {
		return repo.save(st);
	}

	public Student updateStudent(Long id, Student student) {
		return repo.findById(id).map(a -> {
			a.setName(student.getName());
			a.setAge(student.getAge());
			return repo.save(a);
		}).orElseThrow(() -> new RuntimeException("Not found"));
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

}
