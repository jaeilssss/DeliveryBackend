package com.example.deliverybackend.domain.restaurant.entity;

import com.example.deliverybackend.domain.category.entity.Category;
import com.example.deliverybackend.domain.member.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.Point;

import java.util.ArrayList;
import java.util.List;

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
    @JsonIgnore

    private Point location;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    private Double deliveryFee;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "restaurant_id")
    private List<Food> menu = new ArrayList<>();

    public void registerFood(Food food) {
        menu.add(food);
    }
    
}
