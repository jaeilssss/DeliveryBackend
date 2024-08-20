package com.example.deliverybackend.domain.restaurant.service;

import com.example.deliverybackend.domain.order.OrderCommand;
import com.example.deliverybackend.domain.order.info.OrdersInfo;
import com.example.deliverybackend.domain.restaurant.RestaurantCommand;
import com.example.deliverybackend.domain.restaurant.entity.Food;
import com.example.deliverybackend.domain.restaurant.entity.Restaurant;
import com.example.deliverybackend.domain.restaurant.info.RestaurantInfo;

import java.util.List;

public interface RestaurantService {

    public void addRestaurant(RestaurantCommand.AddRestaurantRequest addRestaurantRequest);

    public void registerFood(Long restaurantId, Food food);

    public List<Food> getRegisterFood(Long restaurantId);

    public RestaurantInfo.Main getRestaurant(Long restaurantId);

    List<RestaurantInfo.Main> getNearRestaurant(Double lat, Double lon);
}
