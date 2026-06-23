package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

}
