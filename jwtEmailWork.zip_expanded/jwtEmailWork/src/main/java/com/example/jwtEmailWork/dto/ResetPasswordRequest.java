package com.example.jwtEmailWork.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResetPasswordRequest {
	private String email;
	private String otp;
	private String password;
	private String confirm;
}
