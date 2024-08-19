package com.example.deliverybackend.domain.order.info;

import com.example.deliverybackend.domain.restaurant.entity.Food;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class OrderFoodInfo {

    @Getter
    @Setter
    @ToString
    public static class Main {
        private Long id;
        private Food food;
        private Integer quantity;
    }
}
