package org.spring.application.accuweather.entity;

public class Result {
	
	private String countryName;
	private String stateName;
	private String temperature;
	private String cityName;
	private String weatherText;
	
	public String getWeatherText() {
		return weatherText;
	}
	public void setWeatherText(String weatherText) {
		this.weatherText = weatherText;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	

}
