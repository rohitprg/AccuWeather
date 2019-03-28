package org.spring.application.accuweather.entity;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    private final String locationKey;
    private final String countryName;
    private final String stateName;
    private final String cityName;

    @JsonCreator
    public Location(@JsonProperty("Key") String locationKey,
    		@JsonProperty("Country") Map<String,String> country,
    		@JsonProperty("AdministrativeArea") Map<String,String> state,
    		@JsonProperty("SupplementalAdminAreas") List<Map<String,String>> city){
        this.locationKey = locationKey;
        this.countryName = country.get("EnglishName");
        this.stateName = state.get("EnglishName");
        this.cityName = city.size() > 0 ? city.get(0).get("EnglishName") : null;
    }

    public String getLocationKey() {
        return locationKey;
    }
    
    public String getCountry() {
        return countryName;
    }
    
    public String getAdministrativeArea() {
        return this.stateName;
    }
    
    public String getSupplementalAdminAreas() {
        return this.cityName;
    }
}
