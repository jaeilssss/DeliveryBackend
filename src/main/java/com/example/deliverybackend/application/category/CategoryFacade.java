package com.example.deliverybackend.application.category;

import com.example.deliverybackend.domain.category.CategoryInfoMapperImpl;
import com.example.deliverybackend.domain.category.command.CategoryCommand;
import com.example.deliverybackend.domain.category.info.CategoryInfo;
import com.example.deliverybackend.domain.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryFacade {
    private final CategoryService categoryService;

    public void addCategory(CategoryCommand.AddCategoryRequest addCategoryRequest) {
        categoryService.addCategory(addCategoryRequest);
    }

    public List<CategoryInfo.Main> getAllCategory() {
        return categoryService.getAllCategory();
    }
}
