package com.example.deliverybackend.domain.category.service;

import com.example.deliverybackend.domain.category.CategoryInfoMapper;
import com.example.deliverybackend.domain.category.command.CategoryCommand;
import com.example.deliverybackend.domain.category.dao.CategoryReader;
import com.example.deliverybackend.domain.category.dao.CategoryStore;
import com.example.deliverybackend.domain.category.info.CategoryInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryReader categoryReader;
    private final CategoryStore categoryStore;
    private final CategoryInfoMapper categoryInfoMapper;

    @Override
    public void addCategory(CategoryCommand.AddCategoryRequest createCategoryRequest) {
        categoryReader.isExistCategory(createCategoryRequest.getCategoryName());
        categoryStore.store(createCategoryRequest.toEntity());
    }

    @Override
    public List<CategoryInfo.Main> getAllCategory() {
        return categoryReader.getAllCategory()
                .stream().map(categoryInfoMapper::of)
                .collect(Collectors.toList());
    }

}
