package com.example.deliverybackend.domain.restaurant;

import com.example.deliverybackend.domain.category.entity.Category;
import com.example.deliverybackend.domain.restaurant.entity.Restaurant;
import com.example.deliverybackend.domain.restaurant.info.RestaurantInfo.Main;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-21T21:26:13+0900",
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

        main.setLongitude( restaurant.getLocation().getX() );
        main.setLatitude( restaurant.getLocation().getY() );

        return main;
    }

    @Override
    public List<Main> of(List<Restaurant> list) {
        if ( list == null ) {
            return null;
        }

        List<Main> list1 = new ArrayList<Main>( list.size() );
        for ( Restaurant restaurant : list ) {
            list1.add( of( restaurant ) );
        }

        return list1;
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
