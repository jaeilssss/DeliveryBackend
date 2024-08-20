package com.example.deliverybackend.domain.order.service;

import com.example.deliverybackend.domain.member.info.MemberInfo;
import com.example.deliverybackend.domain.order.OrderCommand;
import com.example.deliverybackend.domain.order.info.OrdersInfo;
import com.example.deliverybackend.domain.restaurant.info.RestaurantInfo;

import java.util.List;

public interface OrdersService {
    public OrdersInfo.Main order(
            MemberInfo.Main memberMain,
            RestaurantInfo.Main restaurantMain,
            List<OrderCommand.OrderMenuRequest> orderFoodList,
            OrderCommand.OrderRequest orderRequest);
}
