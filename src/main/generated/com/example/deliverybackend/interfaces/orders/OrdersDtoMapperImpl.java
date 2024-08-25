package com.example.deliverybackend.interfaces.orders;

import com.example.deliverybackend.domain.order.OrderCommand.OrderFoodRequest;
import com.example.deliverybackend.domain.order.OrderCommand.OrderFoodRequest.OrderFoodRequestBuilder;
import com.example.deliverybackend.domain.order.OrderCommand.OrderRequest;
import com.example.deliverybackend.interfaces.orders.OrdersDto.GetDeliveryFee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-21T22:57:44+0900",
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

        orderRequest1.setRestaurantId( orderRequest.getRestaurantId() );
        orderRequest1.setTotalPrice( orderRequest.getTotalPrice() );
        orderRequest1.setMemberId( orderRequest.getMemberId() );
        orderRequest1.setLat( orderRequest.getLat() );
        orderRequest1.setLon( orderRequest.getLon() );
        orderRequest1.setAddress( orderRequest.getAddress() );

        return orderRequest1;
    }

    @Override
    public List<OrderFoodRequest> of(List<com.example.deliverybackend.interfaces.orders.OrdersDto.OrderFoodRequest> orderFoodList) {
        if ( orderFoodList == null ) {
            return null;
        }

        List<OrderFoodRequest> list = new ArrayList<OrderFoodRequest>( orderFoodList.size() );
        for ( com.example.deliverybackend.interfaces.orders.OrdersDto.OrderFoodRequest orderFoodRequest : orderFoodList ) {
            list.add( orderFoodRequestToOrderFoodRequest( orderFoodRequest ) );
        }

        return list;
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

    protected OrderFoodRequest orderFoodRequestToOrderFoodRequest(com.example.deliverybackend.interfaces.orders.OrdersDto.OrderFoodRequest orderFoodRequest) {
        if ( orderFoodRequest == null ) {
            return null;
        }

        OrderFoodRequestBuilder orderFoodRequest1 = OrderFoodRequest.builder();

        orderFoodRequest1.foodId( orderFoodRequest.getFoodId() );
        orderFoodRequest1.quantity( orderFoodRequest.getQuantity() );

        return orderFoodRequest1.build();
    }
}
