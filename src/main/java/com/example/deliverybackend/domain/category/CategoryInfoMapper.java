package com.example.deliverybackend.domain.category;

import com.example.deliverybackend.domain.category.entity.Category;
import com.example.deliverybackend.domain.category.info.CategoryInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface CategoryInfoMapper {

    CategoryInfo.Main of(Category category);
}
