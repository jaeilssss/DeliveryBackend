package com.example.deliverybackend.domain.restaurant.service;

import com.example.deliverybackend.domain.restaurant.FoodInfoMapper;
import com.example.deliverybackend.domain.restaurant.RestaurantCommand;
import com.example.deliverybackend.domain.restaurant.dao.FoodReader;
import com.example.deliverybackend.domain.restaurant.dao.FoodStore;
import com.example.deliverybackend.domain.restaurant.entity.Food;
import com.example.deliverybackend.domain.restaurant.info.FoodInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService{
    private final FoodStore foodStore;
    private final FoodReader foodReader;
    private final FoodInfoMapper foodInfoMapper;
    @Override
    public Food registerFood(RestaurantCommand.RegisterFood registerFood) {
        return foodStore.registerFood(registerFood.toEntity());
    }

    @Override
    public List<FoodInfo.Main> getFoodList(List<Long> foodIdList) {
        return foodInfoMapper.of(foodReader.findByIdList(foodIdList));
    }
}
