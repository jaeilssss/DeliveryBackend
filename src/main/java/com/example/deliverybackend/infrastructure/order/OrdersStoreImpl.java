package com.example.deliverybackend.infrastructure.order;

import com.example.deliverybackend.domain.order.dao.OrdersStore;
import com.example.deliverybackend.domain.order.entity.Orders;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class OrdersStoreImpl implements OrdersStore {

    private final OrderRepository orderRepository;

    @Override
    public Orders order(Orders orders) {
        return orderRepository.save(orders);
    }
}
