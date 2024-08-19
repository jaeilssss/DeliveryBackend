package com.example.deliverybackend.infrastructure.order;

import com.example.deliverybackend.domain.member.entity.Member;
import com.example.deliverybackend.domain.order.entity.Orders;
import com.example.deliverybackend.domain.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long>, OrderRepositoryCustom {


}
