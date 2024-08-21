package com.example.deliverybackend.domain.order.entity;

import com.example.deliverybackend.domain.member.AbstractEntity;
import com.example.deliverybackend.domain.member.entity.Member;
import com.example.deliverybackend.domain.restaurant.entity.Restaurant;
import com.example.deliverybackend.globals.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Orders extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderFood> orderFoodList;

    private Integer totalPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private String address;

}
