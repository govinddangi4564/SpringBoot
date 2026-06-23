package com.example.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.entity.Patient;
import com.example.crud.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository repo;

	public List<Patient> readAll() {
		return repo.findAll();
	}

	public Patient insert(Patient p) {
		return repo.save(p);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

	public Patient updatePatient(Long id, Patient patient) {
		return repo.findById(id).map(a -> {
			a.setName(patient.getName());
			a.setAdmitDate(patient.getAdmitDate());
			a.setBillAmount(patient.getBillAmount());
			a.setBillStatus(patient.getBillStatus());
			a.setDiagnose(patient.getDiagnose());
			a.setDischargeDate(patient.getDischargeDate());
			a.setDob(patient.getDob());
			a.setDoctorName(patient.getDoctorName());
			return repo.save(a);
		}).orElseThrow(() -> new RuntimeException("Not found"));
	}
}
