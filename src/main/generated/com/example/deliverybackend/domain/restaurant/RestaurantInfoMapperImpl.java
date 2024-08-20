package com.example.deliverybackend.domain.restaurant;

import com.example.deliverybackend.domain.category.entity.Category;
import com.example.deliverybackend.domain.restaurant.entity.Restaurant;
import com.example.deliverybackend.domain.restaurant.info.RestaurantInfo.Main;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-19T16:14:28+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class RestaurantInfoMapperImpl implements RestaurantInfoMapper {

    @Override
    public Main of(Restaurant restaurant) {
        if ( restaurant == null ) {
            return null;
        }

        Main main = new Main();

        main.setCategoryId( restaurantCategoryId( restaurant ) );
        main.setId( restaurant.getId() );
        main.setRestaurantName( restaurant.getRestaurantName() );
        main.setRestaurantDescription( restaurant.getRestaurantDescription() );
        main.setDeliveryFee( restaurant.getDeliveryFee() );
        main.setLocation( restaurant.getLocation() );

        return main;
    }

    private Long restaurantCategoryId(Restaurant restaurant) {
        if ( restaurant == null ) {
            return null;
        }
        Category category = restaurant.getCategory();
        if ( category == null ) {
            return null;
        }
        Long id = category.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
