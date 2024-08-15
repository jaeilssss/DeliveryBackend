package com.example.deliverybackend.domain.category.command;

import com.example.deliverybackend.domain.category.entity.Category;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class CategoryCommand {

    @Getter
    @Setter
    @ToString
    public static class AddCategoryRequest {
        private String categoryName;

        public Category toEntity() {
            return Category.builder()
                    .categoryName(categoryName)
                    .build();
        }
    }

    @Getter
    @Setter
    @ToString
    public static class CategoryRequest {
        private String category;
    }
}
