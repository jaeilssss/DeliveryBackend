package com.example.deliverybackend.domain.restaurant.info;

import com.example.deliverybackend.domain.restaurant.entity.Restaurant;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.locationtech.jts.geom.Point;

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
        private Point location;

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
