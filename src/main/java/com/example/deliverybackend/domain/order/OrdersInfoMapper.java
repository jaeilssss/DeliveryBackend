package com.example.deliverybackend.domain.order;


import com.example.deliverybackend.domain.member.entity.Member;
import com.example.deliverybackend.domain.order.entity.Orders;
import com.example.deliverybackend.domain.order.info.OrdersInfo;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface OrdersInfoMapper {

    @Mappings({
            @Mapping(source = "orders.member.nickName", target = "nickName"),
            @Mapping(source = "orders.restaurant.id", target = "restaurantId"),
            @Mapping(source = "orders.restaurant.restaurantName", target = "restaurantName"),
            @Mapping(source = "orders.orderFoodList", target = "orderMenuList"),
            @Mapping(expression = "java(orders.getStatus().getDescription())", target = "status"),
            @Mapping(source = "orders.id", target = "orderId")
    })
    OrdersInfo.Main of (Orders orders);
}
