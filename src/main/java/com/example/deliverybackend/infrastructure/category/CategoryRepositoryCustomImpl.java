package com.example.deliverybackend.infrastructure.category;

import com.example.deliverybackend.domain.category.entity.Category;
import com.example.deliverybackend.domain.category.entity.QCategory;
import com.example.deliverybackend.domain.restaurant.entity.QRestaurant;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;
    QCategory qCategory = QCategory.category;
    QRestaurant qRestaurant = QRestaurant.restaurant;
    public CategoryRepositoryCustomImpl(EntityManager entityManager) {
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public Optional<Category> findByCategoryName(String categoryName) {
        return Optional.ofNullable(jpaQueryFactory.selectFrom(qCategory)
                .where(qCategory.categoryName.eq(categoryName))
                .fetchOne());
    }

    @Override
    public List<Category> findAll() {
        return jpaQueryFactory.selectFrom(qCategory)
                .join(qCategory.restaurantList, qRestaurant)
                .fetch();
    }

    @Override
    public Optional<Category> findByCategoryId(Long id) {
        return Optional.ofNullable(
                jpaQueryFactory.selectFrom(qCategory)
                        .fetchOne());
    }

}
