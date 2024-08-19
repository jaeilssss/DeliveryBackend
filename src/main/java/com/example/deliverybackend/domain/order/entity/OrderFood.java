package com.example.deliverybackend.domain.order.entity;

import com.example.deliverybackend.domain.member.AbstractEntity;
import com.example.deliverybackend.domain.restaurant.entity.Food;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class OrderFood extends AbstractEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "order_food_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    private Integer quantity;

}
