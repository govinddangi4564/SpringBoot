package com.example.h2_work.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.h2_work.entity.Person;
import com.example.h2_work.service.PersonService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {

	private PersonService service;

	@PostMapping
	public Person create(@RequestBody Person p) {
		return service.create(p);
	}

	@GetMapping
	public List<Person> getAll() {
		return service.getAll();
	}
}
