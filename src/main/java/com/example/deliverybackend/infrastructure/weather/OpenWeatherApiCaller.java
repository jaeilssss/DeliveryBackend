package com.example.deliverybackend.infrastructure.weather;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Component
@RequiredArgsConstructor
public class OpenWeatherApiCaller implements WeatherApiCaller{
    private final WebClient.Builder webClient;

    @Value("${api.openWeatherApiKey}")
    private String apiKey;
    @Value("${api.openWeatherBaseUrl}")
    private String openWeatherUrl;
    @Override
    public OpenWeatherResponse getWeatherData(Double lat, Double lon) {
        WebClient client = webClient
                .baseUrl(openWeatherUrl)
                .build();
        OpenWeatherResponse response = client.get().uri(
                        uriBuilder -> uriBuilder.queryParam("lat",lat)
                                .queryParam("lon",lon)
                                .queryParam("appid",apiKey)
                                .queryParam("units","metric")
                                .queryParam("lang","kr")
                                .build())
                .retrieve().bodyToMono(OpenWeatherResponse.class).block();
        return response;
    }
}
