package com.example.deliverybackend.infrastructure.category;

import com.example.deliverybackend.domain.category.entity.Category;
import com.example.deliverybackend.domain.category.entity.QCategory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    public CategoryRepositoryCustomImpl(EntityManager entityManager) {
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public Optional<Category> findByCategoryName(String categoryName) {
        QCategory qCategory = QCategory.category;

        return Optional.ofNullable(jpaQueryFactory.selectFrom(qCategory)
                .where(qCategory.categoryName.eq(categoryName))
                .fetchOne());
    }
}
