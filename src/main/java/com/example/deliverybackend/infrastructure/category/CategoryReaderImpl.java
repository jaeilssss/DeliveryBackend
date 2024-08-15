package com.example.deliverybackend.infrastructure.category;


import com.example.deliverybackend.domain.category.dao.CategoryReader;
import com.example.deliverybackend.domain.category.entity.Category;
import com.example.deliverybackend.globals.exception.BaseException;
import com.example.deliverybackend.globals.exception.ErrorCode.CategoryErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class CategoryReaderImpl implements CategoryReader {
    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void isExistCategory(String categoryName) {
        categoryRepository.findByCategoryName(categoryName)
                .ifPresent(category -> {
                    throw new BaseException(CategoryErrorCode.EXIST_CATEGORY_NAME.getErrorMsg());
                });
    }
}
