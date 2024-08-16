package com.example.deliverybackend.domain.restaurant.entity;

import com.example.deliverybackend.domain.member.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Food extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long id;

    private String foodName;
    private Integer price;
    private String foodDescription;

}
