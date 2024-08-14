package com.example.deliverybackend.domain.member;

import lombok.*;

public class MemberInfo {

    @Getter
    @ToString
    @Builder
    public static class Main {
        private String email;
        private String nickName;
        private String phoneNumber;

    }

    @Getter
    @ToString
    @Builder
    public static class Login {
        private String accessToken;
        private String refreshToken;
    }

}
