package com.example.jwtWork.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwtWork.dto.JwtResponse;
import com.example.jwtWork.dto.LoginRequest;
import com.example.jwtWork.dto.RegisterRequest;
import com.example.jwtWork.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	@PostMapping("/login")
	public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
		return ResponseEntity.ok(authService.authenticateUser(loginRequest));
	}

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody RegisterRequest registerRequest) {
		return ResponseEntity.ok(authService.registerUser(registerRequest));
	}
}