package com.example.deliverybackend.interfaces.category;


import com.example.deliverybackend.domain.category.command.CategoryCommand;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface CategoryDtoMapper {
    CategoryCommand.AddCategoryRequest of(CategoryDto.AddCategoryRequest addCategoryRequest);
}
