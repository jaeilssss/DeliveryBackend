package com.example.deliverybackend.infrastructure.restaurant;

import com.example.deliverybackend.domain.restaurant.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
