package com.example.weatherapp.service;

import com.example.weatherapp.config.OpenWeatherConfig;
import com.example.weatherapp.dto.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private OpenWeatherConfig config;
    
    public WeatherService(OpenWeatherConfig config) {
    	this.config = config;
    }

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherResponse getWeather(String city) {
        String url = config.buildUrl(city);
        return restTemplate.getForObject(url, WeatherResponse.class);
    }
}
