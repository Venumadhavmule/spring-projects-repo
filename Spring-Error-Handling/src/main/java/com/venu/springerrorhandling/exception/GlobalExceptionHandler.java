package com.venu.springerrorhandling.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex,
			WebRequest request) {
		return buildErrorResponse(ErrorCode.INVALID_INPUT, request.getDescription(false), ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception ex, WebRequest request) {
		return buildErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, request.getDescription(false), ex.getMessage());
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException ex,
			WebRequest request) {
		return buildErrorResponse(ErrorCode.PRODUCT_NOT_FOUND, request.getDescription(false), ex.getMessage());
	}

	private ResponseEntity<ErrorResponse> buildErrorResponse(ErrorCode errorCode, String path, String customMessage) {
		ErrorResponse error = new ErrorResponse(LocalDateTime.now(), errorCode.getStatus(), errorCode.name(),
				customMessage != null ? customMessage : errorCode.getMessage(), path.replace("uri=", ""));
		return new ResponseEntity<>(error, HttpStatus.valueOf(errorCode.getStatus()));
	}
}
