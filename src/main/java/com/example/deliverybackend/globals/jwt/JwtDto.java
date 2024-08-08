package com.example.deliverybackend.globals.jwt;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class JwtDto {
    String accessToken;
    String refreshToken;
}
