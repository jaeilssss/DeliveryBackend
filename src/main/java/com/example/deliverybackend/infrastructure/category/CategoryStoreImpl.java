package com.example.deliverybackend.infrastructure.category;

import com.example.deliverybackend.domain.category.dao.CategoryStore;
import com.example.deliverybackend.domain.category.entity.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CategoryStoreImpl implements CategoryStore {
    private final CategoryRepository categoryRepository;

    @Override
    public void store(Category category) {
        categoryRepository.save(category);
    }
}
