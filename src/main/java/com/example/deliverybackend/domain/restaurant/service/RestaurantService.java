package com.example.deliverybackend.domain.restaurant.service;

import com.example.deliverybackend.domain.restaurant.RestaurantCommand;
import com.example.deliverybackend.domain.restaurant.entity.Food;
import com.example.deliverybackend.domain.restaurant.entity.Restaurant;

import java.util.List;

public interface RestaurantService {

    public void addRestaurant(RestaurantCommand.AddRestaurantRequest addRestaurantRequest);

    public void registerFood(Long restaurantId, Food food);

    public List<Food> getRegisterFood(Long restaurantId);

    public Restaurant getRestaurant(Long restaurantId);

}
