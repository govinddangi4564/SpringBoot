package com.example.MyWork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MyWork.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
