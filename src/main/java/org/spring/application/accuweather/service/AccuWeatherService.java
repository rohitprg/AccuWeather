package org.spring.application.accuweather.service;

import java.net.URI;

import org.spring.application.accuweather.WeatherAppProperties;
import org.spring.application.accuweather.entity.Location;
import org.spring.application.accuweather.entity.Result;
import org.spring.application.accuweather.entity.Weather;
import org.spring.application.accuweather.exception.ZipCodeNotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

@Service
public class AccuWeatherService {

	private static final String WEATHER_URL = "http://dataservice.accuweather.com/currentconditions/v1/{locationKey}?apikey={key}";
	private static final String GET_LOCATION_URL = "http://dataservice.accuweather.com/locations/v1/search?q={zipCode}&apikey={key}";
	private final RestTemplate restTemplate;
	private final String apiKey;
	private final Result result;

	public AccuWeatherService(RestTemplateBuilder restTemplateBuilder,
			WeatherAppProperties properties, Result result) {
		this.restTemplate = restTemplateBuilder.build();
		this.apiKey = properties.getApi().getKey();
		this.result = result;
	}

	public Result tempByZipcode(String zipCode) throws ZipCodeNotFoundException {

		URI url = new UriTemplate(GET_LOCATION_URL)
				.expand(zipCode, this.apiKey);
		Location[] location = invoke(url, Location[].class);
		if (location.length == 0) {

			throw new ZipCodeNotFoundException("Zipcode not found");
		}
		result.setCountryName(location[0].getCountry());
		result.setStateName(location[0].getAdministrativeArea());
		result.setCityName(location[0].getSupplementalAdminAreas());
		url = new UriTemplate(WEATHER_URL).expand(location[0].getLocationKey(),
				this.apiKey);
		Weather weather[] = invoke(url, Weather[].class);
		result.setTemperature(weather[0].getTemperatureF());
		result.setWeatherText(weather[0].getWeatherText());
		return result;
	}

	private <T> T invoke(URI url, Class<T> responseType) {
		RequestEntity<?> request = RequestEntity.get(url)
				.accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<T> exchange = this.restTemplate.exchange(request,
				responseType);
		return exchange.getBody();
	}
}
