package com.example.deliverybackend.domain.order;

import com.example.deliverybackend.domain.member.entity.Member;
import com.example.deliverybackend.domain.order.entity.OrderFood;
import com.example.deliverybackend.domain.order.entity.Orders;
import com.example.deliverybackend.domain.order.info.OrdersInfo.Main;
import com.example.deliverybackend.domain.restaurant.entity.Restaurant;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-18T22:29:40+0900",
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

        main.setNickName( ordersMemberNickName( orders ) );
        Long id = ordersRestaurantId( orders );
        if ( id != null ) {
            main.setRestaurantId( String.valueOf( id ) );
        }
        main.setRestaurantName( ordersRestaurantRestaurantName( orders ) );
        List<OrderFood> list = orders.getOrderFoodList();
        if ( list != null ) {
            main.setOrderMenuList( new ArrayList<OrderFood>( list ) );
        }
        main.setOrderId( orders.getId() );
        main.setTotalPrice( orders.getTotalPrice() );

        main.setStatus( orders.getStatus().getDescription() );

        return main;
    }

    private String ordersMemberNickName(Orders orders) {
        if ( orders == null ) {
            return null;
        }
        Member member = orders.getMember();
        if ( member == null ) {
            return null;
        }
        String nickName = member.getNickName();
        if ( nickName == null ) {
            return null;
        }
        return nickName;
    }

    private Long ordersRestaurantId(Orders orders) {
        if ( orders == null ) {
            return null;
        }
        Restaurant restaurant = orders.getRestaurant();
        if ( restaurant == null ) {
            return null;
        }
        Long id = restaurant.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String ordersRestaurantRestaurantName(Orders orders) {
        if ( orders == null ) {
            return null;
        }
        Restaurant restaurant = orders.getRestaurant();
        if ( restaurant == null ) {
            return null;
        }
        String restaurantName = restaurant.getRestaurantName();
        if ( restaurantName == null ) {
            return null;
        }
        return restaurantName;
    }
}
