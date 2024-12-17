package com.example.weatherapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenWeatherConfig {

    @Value("${openweather.api.url}")
    private String apiUrl;

    @Value("${openweather.api.key}")
    private String apiKey;

    public String buildUrl(String city) {
        return String.format("%s?q=%s&appid=%s&units=metric", apiUrl, city, apiKey);
    }
}
