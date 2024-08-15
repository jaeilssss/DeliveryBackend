package com.example.deliverybackend.domain.category.dao;

import com.example.deliverybackend.domain.category.entity.Category;

import java.util.List;

public interface CategoryReader {
    public List<Category> getAllCategory();
    public void isExistCategory(String categoryName);
    public Category getCategory(Long categoryId);
}
