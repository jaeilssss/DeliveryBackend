package com.example.deliverybackend.infrastructure.order;

import com.example.deliverybackend.domain.member.entity.Member;
import com.example.deliverybackend.domain.order.entity.Orders;
import com.example.deliverybackend.domain.restaurant.entity.Restaurant;

import java.util.List;

public interface OrderRepositoryCustom {
    public List<Orders> findByRestaurant(Restaurant restaurant);
    public List<Orders> findByMember(int page, Member member);

}
