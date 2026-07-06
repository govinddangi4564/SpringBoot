package com.example.paginationOrException.dto;

import java.time.LocalDateTime;

public record CustomerNotFoundError(LocalDateTime timestamp, Integer status , String message) {

}
