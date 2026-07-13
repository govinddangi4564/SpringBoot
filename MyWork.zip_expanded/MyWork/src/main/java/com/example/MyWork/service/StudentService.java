package com.example.MyWork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.MyWork.Exception.ResourceNotFound;
import com.example.MyWork.dto.StudentDetailsShowResponse;
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
	public Page<Student> readAll(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return studentRepo.findAll(pageable);
	}

	// READ by Id
	@Cacheable(value = "student", key = "#id")
	public Student getOne(Long id) {
		return studentRepo.findById(id).orElseThrow(() -> new ResourceNotFound("User Not found"));
	}

	// UPDATE
	public Student updateStudent(Long id, StudentUpdateRequest dto) {
		Student student = studentRepo.findById(id).orElseThrow(() -> new ResourceNotFound("User Not found"));
		student.setName(dto.name());
		student.setPhone(dto.phone());
		return studentRepo.save(student);
	}

	// DELETE
	public void deleteStudent(Long id) {
		Student st = studentRepo.findById(id).orElseThrow(() -> new ResourceNotFound("User Not found"));
		studentRepo.delete(st);
	}

	// SEARCH By Email
	@Cacheable(value = "student", key = "#email")
	public Student findByEmail(String email) {
		return studentRepo.findByEmail(email).orElseThrow(() -> new ResourceNotFound("User Not found"));
	}

	// SEARCHING By Name or Address
	public List<Student> search(String query) {
		return studentRepo.findByNameContainingIgnoreCaseOrAddressContainingIgnoreCase(query, query);
	}

	// READ By DTO (Response)
	public List<StudentDetailsShowResponse> show() {
		List<Student> students = studentRepo.findAll();

		return students.stream().map(
				student -> new StudentDetailsShowResponse(student.getName(), student.getEmail(), student.getPhone()))
				.toList();
	}

	// SORT
	public List<Student> sort(String field, String direction) {
		Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(field).descending() : Sort.by(field).ascending();
		return studentRepo.findAll(sort);
	}

}
