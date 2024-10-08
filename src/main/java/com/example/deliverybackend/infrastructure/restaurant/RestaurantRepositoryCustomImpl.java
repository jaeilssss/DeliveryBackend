package com.example.deliverybackend.infrastructure.restaurant;

import com.example.deliverybackend.application.member.GeometryPoint;
import com.example.deliverybackend.domain.category.entity.QCategory;
import com.example.deliverybackend.domain.restaurant.entity.QFood;
import com.example.deliverybackend.domain.restaurant.entity.QRestaurant;
import com.example.deliverybackend.domain.restaurant.entity.Restaurant;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.ComparablePath;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RestaurantRepositoryCustomImpl implements RestaurantRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;
    private final double RADIUS_IN_METERS = 1000.0;
    QRestaurant qRestaurant = QRestaurant.restaurant;
    QCategory qCategory = QCategory.category;
    QFood qFood = QFood.food;

    public RestaurantRepositoryCustomImpl(EntityManager entityManager) {
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<Restaurant> findNearRestaurant(Double lat, Double lon) {
        // 위도, 경도 값 검증
        if (lat < -90 || lat > 90 || lon < -180 || lon > 180) {
            throw new IllegalArgumentException("Invalid latitude or longitude");
        }

        Point point = GeometryPoint.createPoint(lat, lon);

        BooleanExpression distanceCondition = Expressions.booleanTemplate(
                "function('ST_DWithin', ST_SetSRID({0}, 4326), ST_SetSRID({1}, 4326), {2}) = true",
                qRestaurant.location,
                point,
                RADIUS_IN_METERS
        );
        return jpaQueryFactory.selectFrom(qRestaurant)
                .join(qRestaurant.category, qCategory)
                .leftJoin(qRestaurant.menu, qFood)
                .where(distanceCondition)
                .fetch();
    }

    @Override
    public Optional<Restaurant> findRestaurant(Long id) {
        return Optional.empty();
    }
}
