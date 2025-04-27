package com.venu.springerrorhandling.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex,
			WebRequest request) {
		ErrorResponse error = new ErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Bad Request",
				ex.getMessage(), request.getDescription(false).replace("uri=", ""));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> handleRunTimeException(RuntimeException ex, WebRequest request) {
		ErrorResponse error = new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "Not Found",
				ex.getMessage(), request.getDescription(false).replace("uri=", ""));
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
