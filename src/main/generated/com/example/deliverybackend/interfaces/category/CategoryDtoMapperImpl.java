package com.example.deliverybackend.interfaces.category;

import com.example.deliverybackend.domain.category.command.CategoryCommand.AddCategoryRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-21T21:26:13+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class CategoryDtoMapperImpl implements CategoryDtoMapper {

    @Override
    public AddCategoryRequest of(com.example.deliverybackend.interfaces.category.CategoryDto.AddCategoryRequest addCategoryRequest) {
        if ( addCategoryRequest == null ) {
            return null;
        }

        AddCategoryRequest addCategoryRequest1 = new AddCategoryRequest();

        addCategoryRequest1.setCategoryName( addCategoryRequest.getCategoryName() );

        return addCategoryRequest1;
    }
}
