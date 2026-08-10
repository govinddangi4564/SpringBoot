package com.example.jwtEmailWork.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String username;
	private String email;
	private List<String> roles;
}