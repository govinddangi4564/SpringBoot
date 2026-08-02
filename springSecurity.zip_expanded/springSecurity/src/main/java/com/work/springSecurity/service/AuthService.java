package com.work.springSecurity.service;

import java.util.Set;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Service;

import com.work.springSecurity.dto.ApiResponse;
import com.work.springSecurity.dto.LoginRequest;
import com.work.springSecurity.dto.RegisterRequest;
import com.work.springSecurity.entity.Role;
import com.work.springSecurity.entity.UserEntity;
import com.work.springSecurity.repository.UserEntityRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final UserEntityRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final SecurityContextRepository securityContextRepository;

	public ApiResponse register(RegisterRequest request) {
		if (userRepository.existsByUsername(request.getUsername())) {
			return new ApiResponse(false, "Username is already taken!");
		}

		if (userRepository.existsByEmail(request.getEmail())) {
			return new ApiResponse(false, "Email is already in use!");
		}

//        UserEntity user = UserEntity.builder()
//                .username(request.getUsername())
//                .email(request.getEmail())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .roles(Set.of(Role.ROLE_USER))
//                .build();

		UserEntity user = new UserEntity();
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setEmail(request.getEmail());
		user.setRoles(Set.of(Role.ROLE_USER));

		userRepository.save(user);

		return new ApiResponse(true, "User registered successfully!");
	}

	public ApiResponse login(LoginRequest request, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		SecurityContext context = SecurityContextHolder.createEmptyContext();
		context.setAuthentication(authentication);
		SecurityContextHolder.setContext(context);
		securityContextRepository.saveContext(context, httpRequest, httpResponse);

		return new ApiResponse(true, "Login successful!");
	}
}