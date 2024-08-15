package com.example.deliverybackend.domain.restaurant.service;

import com.example.deliverybackend.domain.restaurant.RestaurantCommand;
import com.example.deliverybackend.domain.restaurant.dao.RestaurantReader;
import com.example.deliverybackend.domain.restaurant.dao.RestaurantStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService{
    private final RestaurantReader restaurantReader;
    private final RestaurantStore restaurantStore;

    @Override
    public void addRestaurant(RestaurantCommand.AddRestaurantRequest addRestaurantRequest) {
        restaurantStore.addRestaurant(addRestaurantRequest.toEntity());
    }

}
