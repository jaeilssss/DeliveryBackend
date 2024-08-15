package com.example.deliverybackend.domain.restaurant.dao;

import com.example.deliverybackend.domain.restaurant.RestaurantCommand;
import com.example.deliverybackend.domain.restaurant.entity.Restaurant;

public interface RestaurantStore {
    public void addRestaurant(Restaurant restaurant);
}
