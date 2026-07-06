package com.example.paginationOrException.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.paginationOrException.entity.Customers;
import com.example.paginationOrException.service.CustomerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

	private CustomerService service;

	@GetMapping
	public Page<Customers> findPage(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return service.getAll(page, size);
	}

	@GetMapping("/{id}")
	public Customers getOne(@PathVariable Long id) {
		return service.getOneCustomers(id);
	}
}
