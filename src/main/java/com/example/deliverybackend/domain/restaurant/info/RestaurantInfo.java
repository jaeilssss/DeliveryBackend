package com.example.deliverybackend.domain.restaurant.info;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.locationtech.jts.geom.Point;

public class RestaurantInfo {

    @Getter
    @Setter
    @ToString
    public static class Main {
        private String restaurantName;
        private String restaurantDescription;
        private Long categoryId;

        private Point location;
    }
}
