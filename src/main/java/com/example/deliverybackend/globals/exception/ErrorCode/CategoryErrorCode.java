package com.example.deliverybackend.globals.exception.ErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CategoryErrorCode {
    EXIST_CATEGORY_NAME("이미 존재하는 카테고리 입니다"),
    INVALID_CATEGORY_ID("유효하지 않은 카테고리 ID 입니다");
    private final String errorMsg;
}
