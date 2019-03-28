package org.spring.application.accuweather.controller;

import org.spring.application.accuweather.entity.Result;
import org.spring.application.accuweather.service.AccuWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccuWeatherController {

	@Autowired
	AccuWeatherService weatherService;

	public AccuWeatherController(AccuWeatherService weatherService) {
		this.weatherService = weatherService;
	}

	@RequestMapping(value = "/findTempByZipcode/{zipCode}", method = RequestMethod.GET)
	public Result tempByZipcode(@PathVariable String zipCode) {
		return this.weatherService.tempByZipcode(zipCode);
	}

}
