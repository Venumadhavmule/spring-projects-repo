package com.venu.springerrorhandling.exception;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex,
			WebRequest request) {
		logger.warn("Invalid input: {}", ex.getMessage());
		return buildErrorResponse(ErrorCode.INVALID_INPUT, request.getDescription(false), ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception ex, WebRequest request) {
		logger.error("Unhandled error at {}: {}", request.getDescription(false), ex.getMessage(), ex);
		return buildErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, request.getDescription(false), ex.getMessage());
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException ex,
			WebRequest request) {
		logger.info("Product not found: {}", ex.getMessage());
		return buildErrorResponse(ErrorCode.PRODUCT_NOT_FOUND, request.getDescription(false), ex.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex,
			WebRequest request) {
		StringBuilder errors = new StringBuilder();
		ex.getBindingResult().getFieldErrors().forEach(
				error -> errors.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("; "));
		logger.warn("Validation failed: {}", errors);
		return buildErrorResponse(ErrorCode.INVALID_INPUT, request.getDescription(false), errors.toString());
	}

	private ResponseEntity<ErrorResponse> buildErrorResponse(ErrorCode errorCode, String path, String customMessage) {
		ErrorResponse error = new ErrorResponse(LocalDateTime.now(), errorCode.getStatus(), errorCode.name(),
				customMessage != null ? customMessage : errorCode.getMessage(), path.replace("uri=", ""));
		return new ResponseEntity<>(error, HttpStatus.valueOf(errorCode.getStatus()));
	}
}
