package com.example.deliverybackend.domain.order.dao;

import com.example.deliverybackend.domain.order.entity.Orders;

public interface OrdersStore {

    public Orders order(Orders orders);
}
