package org.weather.api.controllers;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.weather.api.services.WeatherService;

import java.text.DecimalFormat;

@RestController
public class WeatherInfoController{

    private final WeatherService weatherService;

    private static DecimalFormat df2 = new DecimalFormat("#.##");

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

    @GetMapping("/weatherCityTemp")
    public String getOnlyTemp(@RequestParam(value = "city") String city, RestTemplate restTemplate){
        double temp = this.weatherService.getOnlyTheTemperature(city, restTemplate) - 273.15;
        return "The temperature in " + city + " right now is " + df2.format(temp) + " \u2103";
    }

}
