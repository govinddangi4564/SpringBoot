package com.example.MyWork.dto;

import java.time.LocalDateTime;

public record StudentNotFoundError(LocalDateTime timestamp, Integer status, String message) {

}
