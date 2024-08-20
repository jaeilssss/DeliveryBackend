package com.example.deliverybackend.globals.exception.ErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RestaurantErrorCode {
    NOT_FOUND_RESTAURNAT("해당 id의 음식점은 존재하지않습니다");

    private final String message;
}
