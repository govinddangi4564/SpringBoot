package com.example.paginationOrException.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.paginationOrException.entity.Customers;
import com.example.paginationOrException.errors.CustomerNotFound;
import com.example.paginationOrException.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {
	private CustomerRepository repo;

	public Page<Customers> getAll(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return repo.findAll(pageable);
	}

	public Customers getOneCustomers(Long id) {
		return repo.findById(id).orElseThrow(() -> new CustomerNotFound("Customers not found : " + id));
	}
}

//100 -> page = 0, size = 10 
//page = 1, size = 10 => 11 to 20