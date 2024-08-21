package com.example.deliverybackend.infrastructure.restaurant;

import com.example.deliverybackend.domain.restaurant.entity.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepositoryCustom {
    List<Restaurant> findNearRestaurant(Double lat, Double lon);
    Optional<Restaurant> findRestaurant(Long id);

}
