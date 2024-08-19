package com.example.deliverybackend.domain.member.info;

import com.example.deliverybackend.domain.member.entity.Member;
import lombok.*;

public class MemberInfo {

    @Getter
    @ToString
    @Builder
    public static class Main {
        private Long id;
        private String email;
        private String nickName;
        private String phoneNumber;

        public Member toEntity() {
            return Member.builder()
                    .id(id)
                    .email(email)
                    .nickName(nickName)
                    .phoneNumber(phoneNumber)
                    .build();
        }
    }

    @Getter
    @ToString
    @Builder
    public static class Login {
        private String accessToken;
        private String refreshToken;
    }

}
