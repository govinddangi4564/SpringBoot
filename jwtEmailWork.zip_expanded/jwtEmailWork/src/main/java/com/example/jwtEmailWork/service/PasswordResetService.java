package com.example.jwtEmailWork.service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.jwtEmailWork.dto.ForgotPasswordRequest;
import com.example.jwtEmailWork.dto.ResetPasswordRequest;
import com.example.jwtEmailWork.entity.PasswordResetOtp;
import com.example.jwtEmailWork.entity.UserEntity;
import com.example.jwtEmailWork.repository.PasswordResetRepository;
import com.example.jwtEmailWork.repository.UserEntityRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PasswordResetService {

	private PasswordResetRepository passwordRepo;
	private UserEntityRepository userRepo;
	private EmailService emailService;
	private PasswordEncoder passwordEncoder;

	@Transactional
	public String sendOtp(ForgotPasswordRequest request) {

		String email = request.getEmail();

		if (!userRepo.existsByEmail(email)) {
			return "User not exists";
		}

		SecureRandom random = new SecureRandom();

		String otp = String.valueOf(100000 + random.nextInt(900000));

		PasswordResetOtp data = new PasswordResetOtp();

		data.setEmail(email);
		data.setOtp(otp);
		data.setExpiresAt(LocalDateTime.now().plusMinutes(10));
		data.setUsed(false);

		passwordRepo.save(data);

		emailService.sendOtp(email, otp);

		return "OTP sent successfully";
	}

	@Transactional
	public String resetPassword(ResetPasswordRequest request) {

		String email = request.getEmail();
		String otp = request.getOtp();
		String pass = request.getPassword();
		String confirm = request.getConfirm();

		if (pass == null || confirm == null) {
			return "Password cannot be empty";
		}

		if (!pass.equals(confirm)) {
			return "Password not matched";
		}

		Optional<PasswordResetOtp> dbData = passwordRepo.findTopByEmailAndUsedFalseOrderByIdDesc(email);

		if (dbData.isEmpty()) {
			return "OTP not found";
		}

		PasswordResetOtp data = dbData.get();

		if (data.getExpiresAt().isBefore(LocalDateTime.now())) {
			return "OTP expired";
		}

		if (!data.getOtp().equals(otp)) {
			return "Invalid OTP";
		}

		Optional<UserEntity> userData = userRepo.findByEmail(email);

		if (userData.isEmpty()) {
			return "User not found";
		}

		UserEntity user = userData.get();

		String encodedPassword = passwordEncoder.encode(pass);
		
		user.setPassword(encodedPassword);
		userRepo.save(user);
		
		data.setUsed(true);
		passwordRepo.save(data);
		
		return "Password reset successfully";
	}
}
