package org.weather.api.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.weather.api.entities.AllKeysFromJson;
import org.weather.api.services.WeatherService;

@Service
public class WeatherServicesImpl implements WeatherService {

    public WeatherServicesImpl() {
    }

    public String getAllInformationFromApi(String cityName, RestTemplate restTemplate){
        String url = "http://api.openweathermap.org/data/2.5/weather?q="+ cityName + "&appid=" + "300d4d98f0a405bd551544ed99b60059";
        AllKeysFromJson jsonResponse = restTemplate.getForObject(url, AllKeysFromJson.class);
        return jsonResponse.toString();
    }


}
