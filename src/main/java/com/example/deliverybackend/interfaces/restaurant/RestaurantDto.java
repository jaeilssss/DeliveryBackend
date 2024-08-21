package com.example.deliverybackend.interfaces.restaurant;

import com.example.deliverybackend.application.member.GeometryPoint;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.locationtech.jts.geom.Point;

public class RestaurantDto {

    @Getter
    @Setter
    @ToString
    public static class AddRestaurantRequest {
        @NotBlank
        private String restaurantName;

        private String restaurantDescription;

        private Long categoryId;

        @NotBlank
        private Double latitude;
        @NotBlank
        private Double longitude;

        private Integer deliveryFee;

        private String address;

        public Point setPoint() {
            return GeometryPoint.createPoint(latitude, longitude);
        }

    }

    @Getter
    @Setter
    @ToString
    public static class RegisterFoodRequest {
        private Long restaurantId;
        private String foodName;
        private String foodDescription;
        private Integer price;
    }
}
