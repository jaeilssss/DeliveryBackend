package com.example.deliverybackend.infrastructure.category;

import com.example.deliverybackend.domain.category.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepositoryCustom {
    public Optional<Category> findByCategoryName(String categoryName);
    public List<Category> findAll();
    public Optional<Category> findByCategoryId(Long id);

}
