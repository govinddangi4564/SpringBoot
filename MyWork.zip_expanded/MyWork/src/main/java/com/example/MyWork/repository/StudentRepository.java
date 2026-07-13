package com.example.MyWork.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MyWork.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	Optional<Student> findByEmail(String email);

	Page<Student> findAll(Pageable pageable);

	List<Student> findByNameContainingIgnoreCaseOrAddressContainingIgnoreCase(String name, String address);
}
