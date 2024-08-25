package com.example.deliverybackend.infrastructure.order;

import com.example.deliverybackend.domain.member.entity.Member;
import com.example.deliverybackend.domain.member.entity.QMember;
import com.example.deliverybackend.domain.order.entity.Orders;
import com.example.deliverybackend.domain.order.entity.QOrderFood;
import com.example.deliverybackend.domain.order.entity.QOrders;
import com.example.deliverybackend.domain.restaurant.entity.QFood;
import com.example.deliverybackend.domain.restaurant.entity.QRestaurant;
import com.example.deliverybackend.domain.restaurant.entity.Restaurant;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;


@Repository
public class OrderRepositoryCustomImpl implements OrderRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    QOrders qOrders = QOrders.orders;
    QMember qMember = QMember.member;
    QRestaurant qRestaurant = QRestaurant.restaurant;
    QOrderFood qOrderFood = QOrderFood.orderFood;
    public OrderRepositoryCustomImpl(EntityManager entityManager) {
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }


    public Optional<Orders> findById(Long id) {
        return Optional.ofNullable(jpaQueryFactory.selectFrom(qOrders)
                .join(qOrders.restaurant, qRestaurant).fetchJoin()
                .join(qOrders.member, qMember).fetchJoin()
                .join(qOrders.orderFoodList, qOrderFood).fetchJoin()
                .where(qOrders.id.eq(id))
                .fetchOne());
    }

    @Override
    public List<Orders> findByRestaurant(Restaurant restaurant) {

        return jpaQueryFactory.selectFrom(qOrders)
                .join(qOrders.restaurant, qRestaurant).fetchJoin()
                .join(qOrders.member, qMember).fetchJoin()
                .join(qOrders.orderFoodList, qOrderFood).fetchJoin()
                .where(qOrders.restaurant.eq(restaurant))
                .fetch();
    }

    @Override
    public List<Orders> findByMember(int page, Member member) {
        // 임시로 page size를 2로 해놓음
        PageRequest pageRequest = PageRequest.of(page, 2);
        return jpaQueryFactory.selectFrom(qOrders)
                .join(qOrders.restaurant, qRestaurant).fetchJoin()
                .join(qOrders.member, qMember).fetchJoin()
                .join(qOrders.orderFoodList, qOrderFood).fetchJoin()
                .join(qOrderFood.food, QFood.food).fetchJoin()
                .where(qOrders.member.eq(member))
                .offset(pageRequest.getOffset())
                .limit(pageRequest.getPageSize())
                .fetch();
    }
}
