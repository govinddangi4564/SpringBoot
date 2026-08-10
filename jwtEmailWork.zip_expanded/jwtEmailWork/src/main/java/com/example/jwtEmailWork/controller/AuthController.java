package com.example.jwtEmailWork.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwtEmailWork.dto.ForgotPasswordRequest;
import com.example.jwtEmailWork.dto.JwtResponse;
import com.example.jwtEmailWork.dto.LoginRequest;
import com.example.jwtEmailWork.dto.RegisterRequest;
import com.example.jwtEmailWork.dto.ResetPasswordRequest;
import com.example.jwtEmailWork.service.AuthService;
import com.example.jwtEmailWork.service.PasswordResetService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;
	private final PasswordResetService resetPassword;

	@PostMapping("/login")
	public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
		return ResponseEntity.ok(authService.authenticateUser(loginRequest));
	}

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody RegisterRequest registerRequest) {
		return ResponseEntity.ok(authService.registerUser(registerRequest));
	}

	@PostMapping("/forgot-password")
	public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordRequest request) {
		return ResponseEntity.ok(resetPassword.sendOtp(request));
	}

	@PostMapping("/reset-password")
	public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequest request) {
		return ResponseEntity.ok(resetPassword.resetPassword(request));
	}
}