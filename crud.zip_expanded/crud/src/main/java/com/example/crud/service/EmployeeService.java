package com.example.crud.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.crud.entity.Employee;
import com.example.crud.repository.EmployeeRepository;

import dto.EmployeeRequestDto;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {

	private EmployeeRepository repo;

	public Employee create(EmployeeRequestDto em) {
		Employee e = new Employee();
		e.setName(em.getName());
		e.setEmail(em.getEmail());
		e.setSalary(em.getSalary());

		return repo.save(e);
	}

	public Page<Employee> getAllEmployees(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return repo.findAll(pageable);
	}
}
