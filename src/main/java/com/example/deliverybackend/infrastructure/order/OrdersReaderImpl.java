package com.example.deliverybackend.infrastructure.order;

import com.example.deliverybackend.domain.member.entity.Member;
import com.example.deliverybackend.domain.order.OrderCommand;
import com.example.deliverybackend.domain.order.dao.OrdersReader;
import com.example.deliverybackend.domain.order.entity.Orders;
import com.example.deliverybackend.domain.restaurant.entity.Restaurant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrdersReaderImpl implements OrdersReader {
    private final OrderRepository orderRepository;

    @Override
    public List<Orders> getOrderListFromRestaurant(Restaurant restaurant) {
        return orderRepository.findByRestaurant(restaurant);
    }

    @Override
    public List<Orders> getOrderListFromMember(Member member) {
        return orderRepository.findByMember(member);
    }
}
