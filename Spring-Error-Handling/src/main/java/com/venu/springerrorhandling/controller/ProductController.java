package com.venu.springerrorhandling.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@GetMapping("{id}")
	public String getProductById(@PathVariable int id) {
		if (id < 1) {
			System.out.println("Id " + id + " is less than 1");
			throw new IllegalArgumentException("ID must be greater than zero");
		} else if (id > 100) {
			throw new RuntimeException("Product Not Found");
		}

		return "Product with ID " + id;
	}
}