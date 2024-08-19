package com.example.deliverybackend.infrastructure.weather;

import com.example.deliverybackend.domain.weather.WeatherCommand;

public interface WeatherApiCaller {

    public OpenWeatherResponse getWeatherData(Double lat, Double lon);

}
