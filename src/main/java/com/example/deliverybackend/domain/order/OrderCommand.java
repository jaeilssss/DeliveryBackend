package com.example.deliverybackend.domain.order;

import com.example.deliverybackend.domain.member.entity.Member;
import com.example.deliverybackend.domain.order.entity.OrderFood;
import com.example.deliverybackend.domain.order.entity.Orders;
import com.example.deliverybackend.domain.restaurant.entity.Food;
import com.example.deliverybackend.domain.restaurant.entity.Restaurant;
import com.example.deliverybackend.globals.enums.OrderStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class OrderCommand {

    @Getter
    @Setter
    @ToString
    public static class OrderRequest {
        private Long restaurantId;
        private Integer totalPrice;
        @Enumerated(EnumType.STRING)
        private OrderStatus orderStatus;
        private Long memberId;
        private Double lat;
        private Double lon;
        private String address;

        public Orders toEntity(
                List<OrderFood> orderFoodList,
                Member member,
                Restaurant restaurant) {
            return Orders.builder()
                    .member(member)
                    .restaurant(restaurant)
                    .orderFoodList(orderFoodList)
                    .totalPrice(totalPrice)
                    .status(orderStatus)
                    .address(address)
                    .build();
        }
    }

    @Getter
    @Setter
    @Builder
    public static class OrderFoodRequest {
        private Long foodId;
        private Integer quantity;


    }

    @Getter
    @Setter
    @ToString
    @Builder
    public static class OrderMenuRequest {
        private Food food;
        private Integer quantity;

        public OrderFood toEntity() {
            return OrderFood.builder()
                    .food(food)
                    .quantity(quantity)
                    .build();
        }
    }
}
