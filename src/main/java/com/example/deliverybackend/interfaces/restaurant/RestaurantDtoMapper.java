package com.example.deliverybackend.interfaces.restaurant;


import com.example.deliverybackend.domain.restaurant.RestaurantCommand;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface RestaurantDtoMapper {

    @Mapping(expression = "java(addRestaurantRequest.setPoint())",target = "location")
    RestaurantCommand.AddRestaurantRequest of(RestaurantDto.AddRestaurantRequest addRestaurantRequest);
}
