package com.example.deliverybackend.domain.restaurant;

import com.example.deliverybackend.domain.restaurant.entity.Restaurant;
import com.example.deliverybackend.domain.restaurant.info.RestaurantInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)

public interface RestaurantInfoMapper {

    @Mappings({
            @Mapping(source = "restaurant.category.id", target = "categoryId"),
            @Mapping(expression = "java(restaurant.getLocation().getX())", target ="longitude"),
            @Mapping(expression = "java(restaurant.getLocation().getY())", target = "latitude")
    })
    RestaurantInfo.Main of(Restaurant restaurant);


    @Mapping(source = "restaurant.category.id", target = "categoryId")
    List<RestaurantInfo.Main> of(List<Restaurant> list);
}
