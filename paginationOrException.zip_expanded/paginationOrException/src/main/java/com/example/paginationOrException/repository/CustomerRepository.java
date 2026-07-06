package com.example.paginationOrException.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.paginationOrException.entity.Customers;

public interface CustomerRepository extends JpaRepository<Customers, Long> {

	Page<Customers> findAll(Pageable pageable);
}
