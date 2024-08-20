package com.example.deliverybackend.globals.exception.ErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderErrorCode {
    FOOD_DATA_NOT_CORRECT("주문한 음식의 데이터가 잘못 됐습니다.");

    private final String description;
}
