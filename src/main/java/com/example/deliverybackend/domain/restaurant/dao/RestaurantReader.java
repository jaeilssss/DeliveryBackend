package com.example.deliverybackend.domain.restaurant.dao;

import com.example.deliverybackend.domain.restaurant.entity.Restaurant;

import java.util.List;

public interface RestaurantReader {

    public Restaurant getRestaurant(Long id);
    public List<Restaurant> getNearRestaurant(Double lat, Double lon);
}
