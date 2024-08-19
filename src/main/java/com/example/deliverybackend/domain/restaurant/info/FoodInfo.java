package com.example.deliverybackend.domain.restaurant.info;

import com.example.deliverybackend.domain.restaurant.entity.Food;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class FoodInfo {

    @Getter
    @Setter
    @ToString
    public static class Main {
        private Long id;
        private String foodName;
        private Integer price;
        private String foodDescription;

        public Food toEntity() {
            return Food.builder()
                    .price(price)
                    .foodName(foodName)
                    .foodDescription(foodDescription)
                    .id(id)
                    .build();
        }
    }
}
