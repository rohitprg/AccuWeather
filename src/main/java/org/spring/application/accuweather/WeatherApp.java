package org.spring.application.accuweather;

import org.spring.application.accuweather.entity.Result;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableConfigurationProperties(WeatherAppProperties.class)
public class WeatherApp {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public Result result() {
		return new Result();
	}

	public static void main(String[] args) {
		SpringApplication.run(WeatherApp.class, args);
	}
}
