package com.example.MyWork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MyWork.dto.DepartmentViewResponse;
import com.example.MyWork.entity.Department;
import com.example.MyWork.entity.Student;
import com.example.MyWork.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepo;

	public Department saveDepartment(Department department) {
		if (department.getStudents() != null) {
			for (Student student : department.getStudents()) {
				student.setDepartment(department);
			}
		}
		return departmentRepo.save(department);
	}

	public List<Department> viewAll() {
		return departmentRepo.findAll();
	}

	public List<Department> viewDepartment() {
		List<Department> department = departmentRepo.findAll();

		return departmentRepo.findAll();
	}
}
