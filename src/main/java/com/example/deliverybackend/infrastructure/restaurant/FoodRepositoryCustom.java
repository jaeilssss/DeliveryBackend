package com.example.deliverybackend.infrastructure.restaurant;

import com.example.deliverybackend.domain.restaurant.entity.Food;

import java.util.List;

public interface FoodRepositoryCustom {

    List<Food> findByIdList(List<Long> idList);
}
