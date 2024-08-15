package com.example.deliverybackend.domain.category.service;

import com.example.deliverybackend.domain.category.command.CategoryCommand;
import com.example.deliverybackend.domain.category.entity.Category;
import com.example.deliverybackend.domain.category.info.CategoryInfo;

import java.util.List;

public interface CategoryService {

    public void addCategory(CategoryCommand.AddCategoryRequest categoryRequest);
    public List<CategoryInfo.Main> getAllCategory();
    public Category getCategory(Long categoryId);

}
