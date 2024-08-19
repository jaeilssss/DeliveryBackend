package com.example.deliverybackend.domain.restaurant.service;

import com.example.deliverybackend.domain.order.OrdersInfoMapper;
import com.example.deliverybackend.domain.order.info.OrdersInfo;
import com.example.deliverybackend.domain.restaurant.RestaurantCommand;
import com.example.deliverybackend.domain.restaurant.RestaurantInfoMapper;
import com.example.deliverybackend.domain.restaurant.dao.RestaurantReader;
import com.example.deliverybackend.domain.restaurant.dao.RestaurantStore;
import com.example.deliverybackend.domain.restaurant.entity.Food;
import com.example.deliverybackend.domain.restaurant.entity.Restaurant;
import com.example.deliverybackend.domain.restaurant.info.RestaurantInfo;
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
    private final RestaurantInfoMapper restaurantInfoMapper;
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
    public RestaurantInfo.Main getRestaurant(Long restaurantId) {
        return restaurantInfoMapper.of(restaurantReader.getRestaurant(restaurantId));
    }


}
