package com.example.deliverybackend.domain.restaurant.dao;

import com.example.deliverybackend.domain.restaurant.entity.Food;

import java.util.List;

public interface FoodReader {
    public Food findById(Long id);
    public List<Food> findAll();
}
