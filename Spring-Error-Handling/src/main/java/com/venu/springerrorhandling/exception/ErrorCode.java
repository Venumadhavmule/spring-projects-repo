package com.venu.springerrorhandling.exception;

public enum ErrorCode {
	INVALID_INPUT(400, "Invalid input provided"), PRODUCT_NOT_FOUND(404, "Product Not Found"),
	INTERNAL_SERVER_ERROR(500, "Internal server error");

	private final int status;
	private final String message;

	private ErrorCode(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}
}