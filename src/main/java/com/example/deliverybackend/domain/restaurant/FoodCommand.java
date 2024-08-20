package com.example.deliverybackend.domain.restaurant;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class FoodCommand {

    @Getter
    @Setter
    @ToString
    public static class RegisterFood {
        private String foodName;
        private Integer price;
        private String foodDescription;
    }
}
