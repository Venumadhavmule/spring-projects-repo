package com.example.weatherapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class WeatherResponse {
	private String name; // City name
	private Main main;
	private Wind wind;

	@Data
	public static class Main {
		private double temp;
		private int humidity;
	}

	@Data
	public static class Wind {
		private double speed;
	}
}
