package com.example.deliverybackend.interfaces.orders;

import com.example.deliverybackend.globals.enums.OrderStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class OrdersDto {

    @Getter
    @Setter
    @ToString
    public static class OrderRequest {
        @NotNull
        private Long memberId;
        @NotNull
        private Long restaurantId;
        @NotEmpty
        private List<OrderFoodRequest> orderFoodList;
        @NotNull
        private Integer totalPrice;
        private Double lat;
        private Double lon;
        private String address;

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
