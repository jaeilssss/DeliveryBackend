package com.example.deliverybackend.interfaces.orders;

import com.example.deliverybackend.globals.enums.OrderStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class OrdersDto {

    @Getter
    @Setter
    @ToString
    public static class OrderRequest {
        @NotBlank(message = "memberId는 필수입니다.")
        private Long memberId;
        @NotBlank(message = "restaurantId는 필수입니다.")
        private Long restaurantId;
        @NotBlank(message = "orderMenuList는 필수입니다")
        private List<OrderFoodRequest> orderFoodList;
        @NotBlank
        private Integer totalPrice;
        private Double lat;
        private Double lon;
    }

    @Getter
    @Setter
    @ToString
    public static class OrderFoodRequest {
        @NotBlank
        private Long foodId;
        @NotBlank
        private Integer quantity;
    }

    @Getter
    @Setter
    @ToString
    public static class GetDeliveryFee {

        @NotBlank
        private Double lat;
        @NotBlank
        private Double lon;
    }
}
