package com.example.deliverybackend.globals.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum OrderStatus {
    INIT("주문시작"),
    ORDER_COMPLETE("주문완료"),
    ORDER_CANCELED("주문취소");

    private final String description;
}
