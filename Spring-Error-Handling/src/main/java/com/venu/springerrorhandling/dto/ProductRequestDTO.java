package com.venu.springerrorhandling.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductRequestDTO {
	
	@NotBlank(message = "Product name must not be blank")
	private String name;

	@Min(value = 1, message = "Price must be atleast 1")
	private int price;
}
