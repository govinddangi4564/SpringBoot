package com.example.thymeleafCRUD.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.thymeleafCRUD.entity.Employee;
import com.example.thymeleafCRUD.repository.EmployeeRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class EmployeeService {

	private EmployeeRepository repo;

	public Employee addEmployee(Employee e) {
		return repo.save(e);
	}

	public List<Employee> viewEmployee() {
		return repo.findAll();
	}

	public Employee getEmployeeById(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
	}

	public Employee updateEmployee(Long id, Employee e) {
		Employee em = repo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));

		em.setName(e.getName());
		em.setDepartment(e.getDepartment());
		em.setSalary(e.getSalary());

		return repo.save(em);
	}

	public void deleteEmployee(Long id) {
		repo.deleteById(id);
		log.info("successfully delete");
	}
}
