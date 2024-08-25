package com.example.deliverybackend.application.order;

import com.example.deliverybackend.domain.member.Service.MemberService;
import com.example.deliverybackend.domain.order.OrderCommand;
import com.example.deliverybackend.domain.order.info.OrdersInfo;
import com.example.deliverybackend.domain.order.service.OrdersService;
import com.example.deliverybackend.domain.restaurant.FoodCommand;
import com.example.deliverybackend.domain.restaurant.entity.Food;
import com.example.deliverybackend.domain.restaurant.info.FoodInfo;
import com.example.deliverybackend.domain.restaurant.info.RestaurantInfo;
import com.example.deliverybackend.domain.restaurant.service.FoodService;
import com.example.deliverybackend.domain.restaurant.service.RestaurantService;
import com.example.deliverybackend.domain.weather.WeatherCommand;
import com.example.deliverybackend.globals.enums.OrderStatus;
import com.example.deliverybackend.globals.exception.BaseException;
import com.example.deliverybackend.globals.exception.ErrorCode.OrderErrorCode;
import com.example.deliverybackend.infrastructure.weather.OpenWeatherResponse;
import com.example.deliverybackend.infrastructure.weather.WeatherApiCaller;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrdersFacade {
    private final OrdersService ordersService;
    private final MemberService memberService;
    private final RestaurantService restaurantService;
    private final FoodService foodService;
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
        ArrayList<Long> foodId = new ArrayList<>();
        orderFoodList.forEach(food -> {
            foodId.add(food.getFoodId());
        });
        List<FoodInfo.Main> FoodList = foodService.getFoodList(foodId);
        if(FoodList.size() != orderFoodList.size()) {
            // 사이즈가 다르다는 건 Food 데이터가 잘못됐다는걸 의미 이럴 때 예외처리 해줘야함
            throw new BaseException(OrderErrorCode.FOOD_DATA_NOT_CORRECT.getDescription());
        }
        ArrayList<OrderCommand.OrderMenuRequest> orderMenu = new ArrayList<>();
        for(int i = 0; i<FoodList.size(); i++) {
            OrderCommand.OrderMenuRequest orderMenuRequest  = OrderCommand.OrderMenuRequest.builder()
                    .food(FoodList.get(i).toEntity())
                    .quantity(orderFoodList.get(i).getQuantity())
                    .build();
            orderMenu.add(orderMenuRequest);
        }
        orderRequest.setOrderStatus(OrderStatus.INIT);
        return ordersService.order(
                memberService.getMemberInfo(memberId),
                restaurantService.getRestaurant(restaurantId),
                orderMenu,
                orderRequest);
    }

    public List<OrdersInfo.Main> getOrders(Long memberId, int page) {
        return ordersService.getOrders(memberService.getMemberInfo(memberId),page);
    }

}
