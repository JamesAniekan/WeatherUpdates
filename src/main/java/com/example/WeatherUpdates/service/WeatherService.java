package com.example.WeatherUpdates.service;

import com.example.WeatherUpdates.model.Weather;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class WeatherService {

    @Value("${api.key}")
    private String apiKey;

    RestTemplate restTemplate = new RestTemplate();

    private final Logger LOG = LoggerFactory.getLogger(WeatherService.class);

    //cityweather method returns a jsonobject of api data.
    public JSONObject cityWeather(String city){

        String apiEndpoint = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

        String apiResponse = restTemplate.getForObject(apiEndpoint, String.class);

        LOG.info("API CALL RESULT " + apiResponse);

        return new JSONObject(apiResponse);

    }

    //Required data for Weather properties are extracted from jsonobject data and used to create a Weather object
    //which is returned and cached.
    @Cacheable("weather")
    public Weather getWeather(String city){

        JSONObject responseResult = cityWeather(city);

        Long id  = responseResult.getLong("id");
        String country = responseResult.getJSONObject("sys").getString("country");
        String description = responseResult.getJSONArray("weather").getJSONObject(0).getString("description");
        double temp = responseResult.getJSONObject("main").getDouble("temp");
        double tempMin = responseResult.getJSONObject("main").getDouble("temp_min");
        double tempMax = responseResult.getJSONObject("main").getDouble("temp_max");
        int humidity = responseResult.getJSONObject("main").getInt("humidity");
        int pressure = responseResult.getJSONObject("main").getInt("pressure");
        double windSpeed = responseResult.getJSONObject("wind").getDouble("speed");
        Long visibility  = responseResult.getLong("visibility");


        return           Weather.builder()
                                .id(id)
                                .country(country)
                                .humidity(humidity)
                                .pressure(pressure)
                                .tempMax(tempMax)
                                .tempMin(tempMin)
                                .windSpeed(windSpeed)
                                .visibility(visibility)
                                .description(description)
                                .temperature(temp)
                                .build();


    }



}
