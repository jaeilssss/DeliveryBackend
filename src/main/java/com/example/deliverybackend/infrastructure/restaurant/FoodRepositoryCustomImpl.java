package com.example.deliverybackend.infrastructure.restaurant;

import com.example.deliverybackend.domain.restaurant.entity.Food;
import com.example.deliverybackend.domain.restaurant.entity.QFood;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoodRepositoryCustomImpl implements FoodRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    public FoodRepositoryCustomImpl(EntityManager entityManager) {
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<Food> findByIdList(List<Long> idList) {
        QFood qFood = QFood.food;
        return jpaQueryFactory.selectFrom(qFood)
                .where(qFood.id.in(idList))
                .fetch();
    }
}
