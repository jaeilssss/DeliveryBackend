package com.example.deliverybackend.domain.order;

import com.example.deliverybackend.domain.order.entity.Orders;
import com.example.deliverybackend.domain.order.info.OrdersInfo.Main;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-21T22:57:44+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class OrdersInfoMapperImpl implements OrdersInfoMapper {

    @Override
    public Main of(Orders orders) {
        if ( orders == null ) {
            return null;
        }

        Main main = new Main();

        main.setOrderId( orders.getId() );
        main.setTotalPrice( orders.getTotalPrice() );

        main.setNickName( orders.getMember().getNickName() );
        main.setRestaurantId( orders.getRestaurant().getId() );
        main.setRestaurantName( orders.getRestaurant().getRestaurantName() );
        main.setOrderMenuList( orders.getOrderFoodList() );
        main.setStatus( orders.getStatus().getDescription() );

        return main;
    }
}
