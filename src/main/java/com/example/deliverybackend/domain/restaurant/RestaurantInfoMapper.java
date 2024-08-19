package com.example.deliverybackend.domain.restaurant;

import com.example.deliverybackend.domain.restaurant.entity.Restaurant;
import com.example.deliverybackend.domain.restaurant.info.RestaurantInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)

public interface RestaurantInfoMapper {
    RestaurantInfo.Main of(Restaurant restaurant);
}
