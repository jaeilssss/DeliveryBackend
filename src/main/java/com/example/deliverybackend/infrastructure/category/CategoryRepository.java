package com.example.deliverybackend.infrastructure.category;

import com.example.deliverybackend.domain.category.entity.Category;
import com.example.deliverybackend.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    public Optional<Category> findByCategoryName(String categoryName);
}
