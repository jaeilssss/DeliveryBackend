package com.example.deliverybackend.interfaces.restaurant;

import com.example.deliverybackend.domain.restaurant.RestaurantCommand.AddRestaurantRequest;
import com.example.deliverybackend.domain.restaurant.RestaurantCommand.RegisterFood;
import com.example.deliverybackend.interfaces.restaurant.RestaurantDto.RegisterFoodRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-18T22:29:40+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class RestaurantDtoMapperImpl implements RestaurantDtoMapper {

    @Override
    public AddRestaurantRequest of(com.example.deliverybackend.interfaces.restaurant.RestaurantDto.AddRestaurantRequest addRestaurantRequest) {
        if ( addRestaurantRequest == null ) {
            return null;
        }

        AddRestaurantRequest addRestaurantRequest1 = new AddRestaurantRequest();

        addRestaurantRequest1.setRestaurantName( addRestaurantRequest.getRestaurantName() );
        addRestaurantRequest1.setRestaurantDescription( addRestaurantRequest.getRestaurantDescription() );
        addRestaurantRequest1.setDeliveryFee( addRestaurantRequest.getDeliveryFee() );

        addRestaurantRequest1.setLocation( addRestaurantRequest.setPoint() );

        return addRestaurantRequest1;
    }

    @Override
    public RegisterFood of(RegisterFoodRequest request) {
        if ( request == null ) {
            return null;
        }

        RegisterFood registerFood = new RegisterFood();

        registerFood.setRestaurantId( request.getRestaurantId() );
        registerFood.setFoodName( request.getFoodName() );
        registerFood.setPrice( request.getPrice() );
        registerFood.setFoodDescription( request.getFoodDescription() );

        return registerFood;
    }
}
