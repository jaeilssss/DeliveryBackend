package com.example.deliverybackend.domain.restaurant.service;

import com.example.deliverybackend.domain.restaurant.RestaurantCommand;
import com.example.deliverybackend.domain.restaurant.entity.Food;
import com.example.deliverybackend.domain.restaurant.info.FoodInfo;

import java.util.List;

public interface FoodService {
    public Food registerFood(RestaurantCommand.RegisterFood registerFood);

    public List<FoodInfo.Main> getFoodList(List<Long> foodIdList);
}
