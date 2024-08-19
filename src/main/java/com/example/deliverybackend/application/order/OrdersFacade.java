package com.example.deliverybackend.application.order;

import com.example.deliverybackend.domain.member.Service.MemberService;
import com.example.deliverybackend.domain.order.OrderCommand;
import com.example.deliverybackend.domain.order.info.OrdersInfo;
import com.example.deliverybackend.domain.order.service.OrdersService;
import com.example.deliverybackend.domain.restaurant.info.RestaurantInfo;
import com.example.deliverybackend.domain.restaurant.service.RestaurantService;
import com.example.deliverybackend.domain.weather.WeatherCommand;
import com.example.deliverybackend.globals.enums.OrderStatus;
import com.example.deliverybackend.infrastructure.weather.OpenWeatherResponse;
import com.example.deliverybackend.infrastructure.weather.WeatherApiCaller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrdersFacade {
    private final OrdersService ordersService;
    private final MemberService memberService;
    private final RestaurantService restaurantService;
    private final WeatherApiCaller weatherApiCaller;

    public OpenWeatherResponse getWeatherStatus(Double lat, Double lon) {
        return weatherApiCaller.getWeatherData(lat, lon);
    }
    public OrdersInfo.Main order(
            Long memberId,
            Long restaurantId,
            List<OrderCommand.OrderFoodRequest> orderFoodList,
            OrderCommand.OrderRequest orderRequest) {
        RestaurantInfo.Main restaurantMain= restaurantService.getRestaurant(restaurantId);

        if (getWeatherStatus(orderRequest.getLat(), orderRequest.getLon())
                .getWeather().get(0).getMain().equals("Rain")) {
            // 비 오는 날에는 배달비 500원 추가
            orderRequest.setTotalPrice(orderRequest.getTotalPrice() + restaurantMain.getDeliveryFee()+ 500);
        }
        orderRequest.setOrderStatus(OrderStatus.INIT);
        return ordersService.order(
                memberService.getMemberInfo(memberId),
                restaurantService.getRestaurant(restaurantId),
                orderFoodList,
                orderRequest);
    }

}
