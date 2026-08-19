package com.example.AOP.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AOP.entity.Student;

@Service
public class StudentService {

	private List<Student> student = List.of(new Student(1L, "Govind", "govind.dangi@gmail.com"),
			new Student(1L, "Sunil", "sunil.dangi@gmail.com"), new Student(1L, "Shubham", "subham.dangi@gmail.com"));

	public List<Student> readAll() {
		return student;
	}

	public Student addStudent(Student s) {
		student.add(s);
		return s;
	}

	public Student getOne(Long id) {
		return (Student) student.stream().filter(a -> a.getId() == id);
	}

}
