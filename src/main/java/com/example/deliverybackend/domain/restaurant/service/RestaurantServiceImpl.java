package com.example.deliverybackend.domain.restaurant.service;

import com.example.deliverybackend.domain.restaurant.RestaurantCommand;
import com.example.deliverybackend.domain.restaurant.dao.RestaurantReader;
import com.example.deliverybackend.domain.restaurant.dao.RestaurantStore;
import com.example.deliverybackend.domain.restaurant.entity.Food;
import com.example.deliverybackend.domain.restaurant.entity.Restaurant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantServiceImpl implements RestaurantService{
    private final RestaurantReader restaurantReader;
    private final RestaurantStore restaurantStore;
    @Transactional
    @Override
    public void addRestaurant(RestaurantCommand.AddRestaurantRequest addRestaurantRequest) {
        restaurantStore.addRestaurant(addRestaurantRequest.toEntity());
    }

    @Transactional
    @Override
    public void registerFood(Long restaurantId, Food food) {
        Restaurant restaurant = restaurantReader.getRestaurant(restaurantId);
        restaurant.registerFood(food);
    }

    @Override
    public List<Food> getRegisterFood(Long restaurantId) {
        Restaurant restaurant = restaurantReader.getRestaurant(restaurantId);
        return restaurant.getMenu();
    }

    @Override
    public Restaurant getRestaurant(Long restaurantId) {
        return restaurantReader.getRestaurant(restaurantId);
    }


}
