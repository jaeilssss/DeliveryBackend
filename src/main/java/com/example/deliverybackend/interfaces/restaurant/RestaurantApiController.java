package com.example.deliverybackend.interfaces.restaurant;

import com.example.deliverybackend.application.restaurant.RestaurantFacade;
import com.example.deliverybackend.interfaces.BaseController;
import com.example.deliverybackend.interfaces.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/restaurant")
public class RestaurantApiController extends BaseController {
    private final RestaurantFacade restaurantFacade;
    private final RestaurantDtoMapper restaurantDtoMapper;

    @PostMapping("/create")
    public Response addRestaurant(@RequestBody @Valid RestaurantDto.AddRestaurantRequest addRestaurantRequest) {
        System.out.println(addRestaurantRequest.toString());
        restaurantFacade.addRestaurant(
                restaurantDtoMapper.of(addRestaurantRequest),
                addRestaurantRequest.getCategoryId());
        return Response.success(true);
    }

}
