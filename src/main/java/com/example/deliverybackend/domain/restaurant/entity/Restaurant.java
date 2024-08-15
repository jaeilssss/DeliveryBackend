package com.example.deliverybackend.domain.restaurant.entity;

import com.example.deliverybackend.domain.category.entity.Category;
import com.example.deliverybackend.domain.member.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.Point;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restaurant extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    private String restaurantName;
    private String restaurantDescription;
    private Point location;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private Double deliveryFee;
    
}
