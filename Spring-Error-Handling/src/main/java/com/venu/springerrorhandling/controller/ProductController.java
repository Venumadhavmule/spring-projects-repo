package com.venu.springerrorhandling.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venu.springerrorhandling.dto.ProductRequestDTO;
import com.venu.springerrorhandling.exception.ProductNotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@PostMapping
	public String createProduct(@Valid @RequestBody ProductRequestDTO request) {
		System.out.println(request);
		return "Product Created: " + request.getName() + ", Price: " + request.getPrice();
	}

	@GetMapping("{id}")
	public String getProductById(@PathVariable int id) {
		if (id < 1) {
			System.out.println("Id " + id + " is less than 1");
			throw new IllegalArgumentException("ID must be greater than zero");
		} else if (id > 100) {
			throw new ProductNotFoundException("Product With Id: " + id + " not found");
		}
		return "Product with ID " + id;
	}
}