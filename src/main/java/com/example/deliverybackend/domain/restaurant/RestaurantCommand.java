package com.example.deliverybackend.domain.restaurant;

import com.example.deliverybackend.domain.category.entity.Category;
import com.example.deliverybackend.domain.restaurant.entity.Food;
import com.example.deliverybackend.domain.restaurant.entity.Restaurant;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.locationtech.jts.geom.Point;

public class RestaurantCommand {

    @Getter
    @Setter
    @ToString
    public static class AddRestaurantRequest {
        private String restaurantName;
        private String restaurantDescription;
        private Double deliveryFee;
        private Point location;
        private Category category;

        public Restaurant toEntity() {
            return Restaurant.builder()
                    .restaurantName(restaurantName)
                    .restaurantDescription(restaurantDescription)
                    .category(category)
                    .location(location)
                    .deliveryFee(deliveryFee)
                    .build();
        }
    }

    @Getter
    @Setter
    @ToString
    public static class RegisterFood {
        private Long restaurantId;
        private String foodName;
        private Integer price;
        private String foodDescription;

        public Food toEntity() {
            return Food.builder()
                    .foodName(foodName)
                    .foodDescription(foodDescription)
                    .price(price)
                    .build();
        }
    }
}
