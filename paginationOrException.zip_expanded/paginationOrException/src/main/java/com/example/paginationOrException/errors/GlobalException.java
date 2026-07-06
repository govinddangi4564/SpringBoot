package com.example.paginationOrException.errors;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.paginationOrException.dto.CustomerNotFoundError;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(CustomerNotFound.class)
	public ResponseEntity<CustomerNotFoundError> customerNotFoundExceptionWork(CustomerNotFound e) {
		CustomerNotFoundError error = new CustomerNotFoundError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
