package com.example.WeatherUpdates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class WeatherUpdatesApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(WeatherUpdatesApplication.class, args);
	}

}
