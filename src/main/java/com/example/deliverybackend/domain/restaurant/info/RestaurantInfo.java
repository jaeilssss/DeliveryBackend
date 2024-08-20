package com.example.deliverybackend.domain.restaurant.info;

import com.example.deliverybackend.domain.restaurant.entity.Restaurant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.locationtech.jts.geom.Point;

import java.awt.*;

public class RestaurantInfo {

    @Getter
    @Setter
    @ToString
    public static class Main {
        private Long id;
        private String restaurantName;
        private String restaurantDescription;
        private Long categoryId;
        private Integer deliveryFee;
        private Double latitude;
        private Double longitude;

        public Restaurant toEntity() {
            return Restaurant.builder()
                    .id(id)
                    .restaurantName(restaurantName)
                    .restaurantDescription(restaurantDescription)
                    .deliveryFee(deliveryFee)
                    .build();
        }
    }
}
