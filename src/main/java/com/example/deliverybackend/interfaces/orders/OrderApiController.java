package com.example.deliverybackend.interfaces.orders;

import com.example.deliverybackend.application.order.OrdersFacade;
import com.example.deliverybackend.interfaces.BaseController;
import com.example.deliverybackend.interfaces.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderApiController extends BaseController {
    private final OrdersFacade ordersFacade;
    private final OrdersDtoMapper ordersDtoMapper;

    @GetMapping
    public Response getWeatherStatus(@RequestParam("lat") Double lat, @RequestParam("lon") Double lon) {
        return Response.success(ordersFacade.getWeatherStatus(lat, lon).getWeather().get(0).getMain());
    }
    @PostMapping
    public Response order(@RequestBody @Valid OrdersDto.OrderRequest orderRequest){
        return Response.success(ordersFacade.order(
                orderRequest.getMemberId(),
                orderRequest.getRestaurantId(),
                ordersDtoMapper.of(orderRequest.getOrderFoodList()),
                ordersDtoMapper.of(orderRequest)));
    }
}
