package com.example.WeatherUpdates.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Weather {
    Long id;
    String description;
    String country;
    double temperature;
    double tempMin;
    double tempMax;
    double windSpeed;
    int humidity;
    int pressure;
    Long visibility;

}
