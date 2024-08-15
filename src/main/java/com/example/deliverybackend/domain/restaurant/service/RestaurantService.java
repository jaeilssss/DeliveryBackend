package com.example.deliverybackend.domain.restaurant.service;

import com.example.deliverybackend.domain.restaurant.RestaurantCommand;

public interface RestaurantService {

    public void addRestaurant(RestaurantCommand.AddRestaurantRequest addRestaurantRequest);

}
