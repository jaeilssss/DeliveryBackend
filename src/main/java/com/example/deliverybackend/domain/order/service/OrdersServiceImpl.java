package com.example.deliverybackend.domain.order.service;

import com.example.deliverybackend.domain.member.info.MemberInfo;
import com.example.deliverybackend.domain.order.OrderCommand;
import com.example.deliverybackend.domain.order.OrdersInfoMapper;
import com.example.deliverybackend.domain.order.dao.OrdersReader;
import com.example.deliverybackend.domain.order.dao.OrdersStore;
import com.example.deliverybackend.domain.order.entity.Orders;
import com.example.deliverybackend.domain.order.info.OrdersInfo;
import com.example.deliverybackend.domain.restaurant.info.RestaurantInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService{
    private final OrdersReader ordersReader;
    private final OrdersStore ordersStore;
    private final OrdersInfoMapper ordersInfoMapper;

    @Override
    public OrdersInfo.Main order(
            MemberInfo.Main memberMain,
            RestaurantInfo.Main restaurantMain,
            List<OrderCommand.OrderMenuRequest> orderFoodList,
            OrderCommand.OrderRequest orderRequest
    ) {
        Orders orders = ordersStore.order(
                orderRequest.toEntity(
                        orderFoodList.stream().map(OrderCommand.OrderMenuRequest::toEntity).collect(Collectors.toList()),
                        memberMain.toEntity(),
                        restaurantMain.toEntity()
                ));
        return ordersInfoMapper.of(orders);
    }
}
