package com.work.springSecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.work.springSecurity.dto.ApiResponse;
import com.work.springSecurity.dto.LoginRequest;
import com.work.springSecurity.dto.RegisterRequest;
import com.work.springSecurity.service.AuthService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	@PostMapping("/register")
	public ResponseEntity<ApiResponse> registerUser(@RequestBody RegisterRequest registerRequest) {
		ApiResponse response = authService.register(registerRequest);
		if (!response.getSuccess()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PostMapping("/login")
	public ResponseEntity<ApiResponse> loginUser(@RequestBody LoginRequest loginRequest, HttpServletRequest request,
			HttpServletResponse response) {
		ApiResponse apiResponse = authService.login(loginRequest, request, response);
		return ResponseEntity.ok(apiResponse);
	}

	@GetMapping("/hello")
	public String helloAPi() {
		return "This is a hello public api.. ";
	}
}