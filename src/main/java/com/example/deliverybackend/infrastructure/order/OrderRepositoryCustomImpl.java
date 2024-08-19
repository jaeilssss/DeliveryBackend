package com.example.deliverybackend.infrastructure.order;

import com.example.deliverybackend.domain.member.entity.Member;
import com.example.deliverybackend.domain.order.entity.Orders;
import com.example.deliverybackend.domain.order.entity.QOrders;
import com.example.deliverybackend.domain.restaurant.entity.Restaurant;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class OrderRepositoryCustomImpl implements OrderRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    QOrders qOrders = QOrders.orders;
    public OrderRepositoryCustomImpl(EntityManager entityManager) {
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<Orders> findByRestaurant(Restaurant restaurant) {
        return jpaQueryFactory.selectFrom(qOrders)
                .where(qOrders.restaurant.eq(restaurant))
                .fetch();
    }

    @Override
    public List<Orders> findByMember(Member member) {
        return jpaQueryFactory.selectFrom(qOrders)
                .where(qOrders.member.eq(member))
                .fetch();
    }
}
