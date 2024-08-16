package com.example.deliverybackend.interfaces.restaurant;

import com.example.deliverybackend.application.restaurant.RestaurantFacade;
import com.example.deliverybackend.interfaces.BaseController;
import com.example.deliverybackend.interfaces.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/restaurant")
public class RestaurantApiController extends BaseController {
    private final RestaurantFacade restaurantFacade;
    private final RestaurantDtoMapper restaurantDtoMapper;

    @PostMapping("/create")
    public Response addRestaurant(@RequestBody @Valid RestaurantDto.AddRestaurantRequest addRestaurantRequest) {
        System.out.println(addRestaurantRequest.getRestaurantName());
        System.out.println(addRestaurantRequest.getLatitude());
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

}
