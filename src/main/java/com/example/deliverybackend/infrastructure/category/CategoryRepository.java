package com.example.deliverybackend.infrastructure.category;

import com.example.deliverybackend.domain.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> , CategoryRepositoryCustom{
}
