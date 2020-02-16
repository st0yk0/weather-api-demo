package org.weather.api.controllers;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.weather.api.services.WeatherService;

@RestController
public class WeatherInfoController{

    private final WeatherService weatherService;

    public WeatherInfoController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }



    @GetMapping("/weatherCity")
    public String addService(@RequestParam(value = "city") String city, RestTemplate restTemplate){
        return this.weatherService.getAllInformationFromApi(city, restTemplate);
    }

}
