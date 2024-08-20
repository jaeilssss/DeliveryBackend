package com.example.deliverybackend.domain.order.info;

import com.example.deliverybackend.domain.order.entity.OrderFood;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class OrdersInfo {

    @Getter
    @Setter
    @ToString
    public static class Main {
        private Long orderId;
        private String nickName;
        private String restaurantId;
        private String restaurantName;
        private List<OrderFood> orderMenuList;
        private Integer totalPrice;
        private String status;
    }
}
