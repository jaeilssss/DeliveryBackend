package com.example.deliverybackend.interfaces.orders;

import com.example.deliverybackend.domain.order.OrderCommand;
import com.example.deliverybackend.domain.weather.WeatherCommand;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface OrdersDtoMapper {

    OrderCommand.OrderRequest of(OrdersDto.OrderRequest orderRequest);
    List<OrderCommand.OrderFoodRequest> of(List<OrdersDto.OrderFoodRequest> orderFoodList);
    WeatherCommand.GetDeliveryFee of(OrdersDto.GetDeliveryFee getDeliveryFee);
}
