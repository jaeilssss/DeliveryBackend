package com.example.deliverybackend.interfaces.restaurant;

import com.example.deliverybackend.application.member.GeometryPoint;
import com.example.deliverybackend.application.restaurant.RestaurantFacade;
import com.example.deliverybackend.domain.restaurant.entity.QRestaurant;
import com.example.deliverybackend.domain.restaurant.entity.Restaurant;
import com.example.deliverybackend.domain.restaurant.info.RestaurantInfo;
import com.example.deliverybackend.interfaces.BaseController;
import com.example.deliverybackend.interfaces.Response;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberTemplate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.locationtech.jts.geom.Point;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

import static com.querydsl.core.types.dsl.Expressions.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/restaurant")
public class RestaurantApiController extends BaseController {
    private final RestaurantFacade restaurantFacade;
    private final RestaurantDtoMapper restaurantDtoMapper;

    @PostMapping("/create")
    public Response addRestaurant(@RequestBody @Valid RestaurantDto.AddRestaurantRequest addRestaurantRequest) {
        restaurantFacade.addRestaurant(
                restaurantDtoMapper.of(addRestaurantRequest),
                addRestaurantRequest.getCategoryId());
        return Response.success(true);
    }

    @PostMapping("/register/food")
    public Response registerFood(@RequestBody @Valid RestaurantDto.RegisterFoodRequest request) {
        restaurantFacade.registerFood(restaurantDtoMapper.of(request));
        return Response.success(true);
    }

    @GetMapping("/{restaurantId}")
    public Response getRestaurant(@PathVariable("restaurantId") Long restaurantId) {
        return Response.success(restaurantFacade.getRestaurant(restaurantId));
    }

    @GetMapping("/near/restaurant")
    public Response getNearRestaurant(@RequestParam("lat") Double lat, @RequestParam("lon") Double lon) {
        return Response.success(restaurantFacade.getNearRestaurant(lat, lon));
    }

}
