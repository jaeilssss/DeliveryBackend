package com.example.deliverybackend.domain.restaurant.service;

import com.example.deliverybackend.domain.restaurant.RestaurantCommand;
import com.example.deliverybackend.domain.restaurant.entity.Food;

public interface FoodService {
    public Food registerFood(RestaurantCommand.RegisterFood registerFood);
}
