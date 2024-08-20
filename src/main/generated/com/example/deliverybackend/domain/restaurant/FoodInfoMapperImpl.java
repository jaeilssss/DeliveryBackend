package com.example.deliverybackend.domain.restaurant;

import com.example.deliverybackend.domain.restaurant.entity.Food;
import com.example.deliverybackend.domain.restaurant.info.FoodInfo.Main;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-20T11:40:01+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class FoodInfoMapperImpl implements FoodInfoMapper {

    @Override
    public List<Main> of(List<Food> foodList) {
        if ( foodList == null ) {
            return null;
        }

        List<Main> list = new ArrayList<Main>( foodList.size() );
        for ( Food food : foodList ) {
            list.add( foodToMain( food ) );
        }

        return list;
    }

    protected Main foodToMain(Food food) {
        if ( food == null ) {
            return null;
        }

        Main main = new Main();

        main.setId( food.getId() );
        main.setFoodName( food.getFoodName() );
        main.setPrice( food.getPrice() );
        main.setFoodDescription( food.getFoodDescription() );

        return main;
    }
}
