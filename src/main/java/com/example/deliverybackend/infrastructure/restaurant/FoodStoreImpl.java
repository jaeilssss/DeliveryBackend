package com.example.deliverybackend.infrastructure.restaurant;

import com.example.deliverybackend.domain.restaurant.dao.FoodStore;
import com.example.deliverybackend.domain.restaurant.entity.Food;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FoodStoreImpl implements FoodStore {
    private final FoodRepository foodRepository;

    public Food registerFood(Food food) {
        return foodRepository.save(food);
    }
}
