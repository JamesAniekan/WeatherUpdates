package com.example.WeatherUpdates.controller;

import com.example.WeatherUpdates.model.Weather;
import com.example.WeatherUpdates.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CityWeatherController {

    WeatherService weatherService;

    @GetMapping("/weather/{city}")
    public Weather getCityWeather(@PathVariable String city){
        return weatherService.getWeather(city);
    }
}
