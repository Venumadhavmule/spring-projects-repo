package com.example.weatherapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weatherapp.dto.WeatherResponse;
import com.example.weatherapp.service.WeatherService;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

	private WeatherService weatherService;

	public WeatherController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	@GetMapping("/{city}")
	public WeatherResponse getWeather(@PathVariable String city) {
		return weatherService.getWeather(city);
	}
}
