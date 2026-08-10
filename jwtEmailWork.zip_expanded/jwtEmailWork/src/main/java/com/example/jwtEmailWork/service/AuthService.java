package com.example.jwtEmailWork.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.jwtEmailWork.config.JwtUtils;
import com.example.jwtEmailWork.dto.JwtResponse;
import com.example.jwtEmailWork.dto.LoginRequest;
import com.example.jwtEmailWork.dto.RegisterRequest;
import com.example.jwtEmailWork.entity.Role;
import com.example.jwtEmailWork.entity.UserEntity;
import com.example.jwtEmailWork.repository.UserEntityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserEntityRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public JwtResponse authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        UserEntity user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();

        return JwtResponse.builder()
                .token(jwt)
                .type("Bearer")
                .username(user.getUsername())
                .email(user.getEmail())
                .roles(roles)
                .build();
    }

    public String registerUser(RegisterRequest registerRequest) {
        if (userRepository.existsByUsername(registerRequest.getUsername())) {
            throw new RuntimeException("Error: Username is already taken!");
        }

        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new RuntimeException("Error: Email is already in use!");
        }

        UserEntity user = UserEntity.builder()
                .username(registerRequest.getUsername())
                .email(registerRequest.getEmail())
                .name(registerRequest.getName())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .roles(Set.of(Role.ROLE_USER))
                .build();

        userRepository.save(user);
        return "User registered successfully!";
    }
}