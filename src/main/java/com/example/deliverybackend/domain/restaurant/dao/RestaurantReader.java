package com.example.deliverybackend.domain.restaurant.dao;

import com.example.deliverybackend.domain.restaurant.entity.Restaurant;

public interface RestaurantReader {

    public Restaurant getRestaurant(Long id);
}
