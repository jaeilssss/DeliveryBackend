package com.example.deliverybackend.application.restaurant;

import com.example.deliverybackend.domain.category.entity.Category;
import com.example.deliverybackend.domain.category.service.CategoryService;
import com.example.deliverybackend.domain.restaurant.RestaurantCommand;
import com.example.deliverybackend.domain.restaurant.entity.Restaurant;
import com.example.deliverybackend.domain.restaurant.service.FoodService;
import com.example.deliverybackend.domain.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestaurantFacade {
    private final RestaurantService restaurantService;
    private final FoodService foodService;
    private final CategoryService categoryService;

    public void addRestaurant(
            RestaurantCommand.AddRestaurantRequest addRestaurantRequest,
            Long categoryId) {
        //먼저 카테고리 아이디를 찾는다
        Category category = categoryService.getCategory(categoryId);
        //찾은 카테고리를 넣어준다
        addRestaurantRequest.setCategory(category);

        //restaurant 추가
        restaurantService.addRestaurant(addRestaurantRequest);
    }

    public void registerFood(RestaurantCommand.RegisterFood registerFood) {
//        foodService.registerFood(registerFood)
        restaurantService.registerFood(registerFood.getRestaurantId(),registerFood.toEntity());
    }

    public Restaurant getRestaurant(Long restaurantId) {
        return restaurantService.getRestaurant(restaurantId);
    }
}
