package com.example.deliverybackend.domain.category;

import com.example.deliverybackend.domain.category.entity.Category;
import com.example.deliverybackend.domain.category.info.CategoryInfo.Main;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-18T22:29:40+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class CategoryInfoMapperImpl implements CategoryInfoMapper {

    @Override
    public Main of(Category category) {
        if ( category == null ) {
            return null;
        }

        Main main = new Main();

        main.setId( category.getId() );
        main.setCategoryName( category.getCategoryName() );

        return main;
    }
}
