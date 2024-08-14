package com.example.deliverybackend.domain.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.locationtech.jts.geom.Point;

public class MemberCommand {

    @Getter
    @Setter
    @ToString
    public static class CreateMemberRequest {
        private String email;
        private String password;
        private String nickName;
        private String phoneNumber;
        private Point location;

        public Member toEntity() {
            return Member.builder()
                    .email(email)
                    .password(password)
                    .nickName(nickName)
                    .phoneNumber(phoneNumber)
                    .location(location)
                    .build();
        }
    }

    @Getter
    @Setter
    @ToString
    public static class LoginRequest {
        String email;
        String password;
    }

    @Getter
    @Setter
    @ToString
    public static class CheckPassword {
        Long memberId;
        String password;
    }

    @Getter
    @Setter
    @ToString
    public static class ModifyMember {
        Long memberId;
        String encodedKey;
        String nickName;
        String phoneNumber;
    }
}
