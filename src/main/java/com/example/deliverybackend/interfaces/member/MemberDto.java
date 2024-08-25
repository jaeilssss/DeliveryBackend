package com.example.deliverybackend.interfaces.member;

import com.example.deliverybackend.application.member.GeometryPoint;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.locationtech.jts.geom.Point;

public class MemberDto {

    @Getter
    @Setter
    @ToString
    public static class CreateMemberRequest {
        @NotBlank(message = "email은 필수값입니다.")
        private String email;
        @NotBlank(message = "password는 필수값 입니다.")
        private String password;
        @NotBlank(message = "닉네임 값은 필수 입니다.")
        private String nickName;
        private String phoneNumber;

        private Double latitude;
        private Double longitude;

        public Point setPoint() {
            return GeometryPoint.createPoint(latitude, longitude);
        }
    }


    @Getter
    @Setter
    @ToString
    public static class LoginMemberRequest {
        @NotBlank(message = "email은 필수값 입니다.")
        private String email;
        @NotBlank(message = "password는 필수값 입니다.")
        private String password;
    }

    @Getter
    @Setter
    @ToString
    public static class ModifyMemberRequest {
        @NotBlank(message = "encodedKey는 필수값 입니다.")
        String encodedKey;
        @NotBlank(message = "nickName은 필수값 입니다.")
        private String nickName;
        @NotBlank(message = "phoneNumber은 필수값 입니다.")
        private String phoneNumber;
    }

    @Getter
    @Setter
    @ToString
    public static class CheckPassword {
        @NotBlank(message = "password는 필수값 입니다.")
        private String password;
    }
}
