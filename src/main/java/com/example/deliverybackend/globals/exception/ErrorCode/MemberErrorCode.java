package com.example.deliverybackend.globals.exception.ErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberErrorCode {
    MEMBER_NOT_FOUND_ERROR("존재 하지 않은 유저 정보 입니다"),
    EXIST_EMAIL_ERROR("이미 존재한 이메일 입니다"),
    EXIST_NICKNAME_ERROR("이미 존재 한 닉네임 입니다"),
    INVALID_LOGIN_REQUEST("이메일, 비밀번호가 일치하지않습니다"),
    INCORRECT_PASSWORD("비밀번호가 잘못 입력되었습니다"),
    INVALID_REQUEST("유효하지 않은 요청입니다.");

    private final String errorMsg;
}
