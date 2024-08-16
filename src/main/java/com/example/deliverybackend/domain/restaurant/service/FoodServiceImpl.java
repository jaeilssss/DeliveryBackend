package com.example.deliverybackend.domain.restaurant.service;

import com.example.deliverybackend.domain.restaurant.RestaurantCommand;
import com.example.deliverybackend.domain.restaurant.dao.FoodStore;
import com.example.deliverybackend.domain.restaurant.entity.Food;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService{
    private final FoodStore foodStore;
    @Override
    public Food registerFood(RestaurantCommand.RegisterFood registerFood) {
        return foodStore.registerFood(registerFood.toEntity());
    }
}
