package com.venu.springerrorhandling.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorResponse {
	private LocalDateTime timestamp;
	private int status;
	private String error;
	private String message;
	private String path;
}
