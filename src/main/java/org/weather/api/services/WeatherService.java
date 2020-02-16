package org.weather.api.services;

import org.springframework.web.client.RestTemplate;

public interface WeatherService {

    String getAllInformationFromApi(String cityName, RestTemplate restTemplate);
}
