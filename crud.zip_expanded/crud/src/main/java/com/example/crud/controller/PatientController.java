package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.entity.Patient;
import com.example.crud.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService service;

	@GetMapping
	public List<Patient> getAllPatient() {
		return service.readAll();
	}

	@PostMapping
	public Patient savePatient(@RequestBody Patient p) {
		return service.insert(p);
	}
	
	public String deletePatient(@PathVariable Long id) {
		service.delete(id);
		return "Delete Successfully";
	}
	
	public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
		return service.updatePatient(id, patient);
	}
}
