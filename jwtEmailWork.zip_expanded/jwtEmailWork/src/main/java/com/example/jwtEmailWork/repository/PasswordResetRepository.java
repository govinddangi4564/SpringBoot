package com.example.jwtEmailWork.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jwtEmailWork.entity.PasswordResetOtp;

@Repository
public interface PasswordResetRepository extends JpaRepository<PasswordResetOtp, Long> {

	Optional<PasswordResetOtp> findTopByEmailAndUsedFalseOrderByIdDesc(String email);
}