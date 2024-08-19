package com.example.deliverybackend.domain.weather;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class WeatherCommand {
    @Getter
    @Setter
    @ToString
    public static class GetDeliveryFee {
        private Double lat;
        private Double lon;
    }
}
