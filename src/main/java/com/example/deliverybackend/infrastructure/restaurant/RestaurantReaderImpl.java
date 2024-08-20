package com.example.deliverybackend.infrastructure.restaurant;

import com.example.deliverybackend.domain.restaurant.dao.RestaurantReader;
import com.example.deliverybackend.domain.restaurant.entity.Restaurant;
import com.example.deliverybackend.globals.exception.BaseException;
import com.example.deliverybackend.globals.exception.ErrorCode.RestaurantErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class RestaurantReaderImpl implements RestaurantReader {
    private final RestaurantRepository restaurantRepository;

    @Override
    public Restaurant getRestaurant(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new BaseException(RestaurantErrorCode.NOT_FOUND_RESTAURNAT.getMessage()));
    }

    @Override
    public List<Restaurant> getNearRestaurant(Double lat, Double lon) {
        return restaurantRepository.findNearRestaurant(lat,lon);
    }
}
