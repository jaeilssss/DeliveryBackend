package com.example.deliverybackend.domain.order.dao;

import com.example.deliverybackend.domain.member.entity.Member;
import com.example.deliverybackend.domain.order.OrderCommand;
import com.example.deliverybackend.domain.order.entity.Orders;
import com.example.deliverybackend.domain.restaurant.entity.Restaurant;

import java.util.List;

public interface OrdersReader {
    public List<Orders> getOrderListFromRestaurant(Restaurant restaurant);
    public List<Orders> getOrderListFromMember(int page, Member member);
}
