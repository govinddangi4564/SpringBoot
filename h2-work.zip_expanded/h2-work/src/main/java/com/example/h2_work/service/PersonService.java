package com.example.h2_work.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.h2_work.entity.Person;
import com.example.h2_work.repository.PersonRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonService {

	private PersonRepository repo;

	public Person create(Person p) {
		return repo.save(p);
	}

	public List<Person> getAll() {
		return repo.findAll();
	}

}
