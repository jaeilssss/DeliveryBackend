package com.example.deliverybackend.domain.category.info;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class CategoryInfo {

    @Getter
    @Setter
    @ToString
    public static class Main {
        private Long id;
        private String categoryName;
    }
}
