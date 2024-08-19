package com.example.deliverybackend.interfaces.orders;

import com.example.deliverybackend.domain.order.OrderCommand.OrderRequest;
import com.example.deliverybackend.interfaces.orders.OrdersDto.GetDeliveryFee;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-18T22:29:40+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class OrdersDtoMapperImpl implements OrdersDtoMapper {

    @Override
    public OrderRequest of(com.example.deliverybackend.interfaces.orders.OrdersDto.OrderRequest orderRequest) {
        if ( orderRequest == null ) {
            return null;
        }

        OrderRequest orderRequest1 = new OrderRequest();

        return orderRequest1;
    }

    @Override
    public com.example.deliverybackend.domain.weather.WeatherCommand.GetDeliveryFee of(GetDeliveryFee getDeliveryFee) {
        if ( getDeliveryFee == null ) {
            return null;
        }

        com.example.deliverybackend.domain.weather.WeatherCommand.GetDeliveryFee getDeliveryFee1 = new com.example.deliverybackend.domain.weather.WeatherCommand.GetDeliveryFee();

        getDeliveryFee1.setLat( getDeliveryFee.getLat() );
        getDeliveryFee1.setLon( getDeliveryFee.getLon() );

        return getDeliveryFee1;
    }
}
