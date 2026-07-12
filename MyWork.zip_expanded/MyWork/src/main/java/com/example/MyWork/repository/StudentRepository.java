package com.example.MyWork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MyWork.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
