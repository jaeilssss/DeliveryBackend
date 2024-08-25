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
            @Mapping(expression = "java(orders.getMember().getNickName())", target = "nickName"),
            @Mapping(expression = "java(orders.getRestaurant().getId())", target = "restaurantId"),
            @Mapping(expression = "java(orders.getRestaurant().getRestaurantName())", target = "restaurantName"),
            @Mapping(expression = "java(orders.getOrderFoodList())", target = "orderMenuList"),
            @Mapping(expression = "java(orders.getStatus().getDescription())", target = "status"),
            @Mapping(source = "orders.id", target = "orderId")
    })
    OrdersInfo.Main of (Orders orders);
}
