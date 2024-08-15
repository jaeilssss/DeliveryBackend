package com.example.deliverybackend.interfaces.category;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class CategoryDto {

    @Getter
    @Setter
    @ToString
    public static class AddCategoryRequest {
        private String categoryName;
    }
}
