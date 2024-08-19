package com.example.deliverybackend.domain.category.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCategory is a Querydsl query type for Category
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCategory extends EntityPathBase<Category> {

    private static final long serialVersionUID = -323549180L;

    public static final QCategory category = new QCategory("category");

    public final com.example.deliverybackend.domain.member.QAbstractEntity _super = new com.example.deliverybackend.domain.member.QAbstractEntity(this);

    public final StringPath categoryName = createString("categoryName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<com.example.deliverybackend.domain.restaurant.entity.Restaurant, com.example.deliverybackend.domain.restaurant.entity.QRestaurant> restaurantList = this.<com.example.deliverybackend.domain.restaurant.entity.Restaurant, com.example.deliverybackend.domain.restaurant.entity.QRestaurant>createList("restaurantList", com.example.deliverybackend.domain.restaurant.entity.Restaurant.class, com.example.deliverybackend.domain.restaurant.entity.QRestaurant.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QCategory(String variable) {
        super(Category.class, forVariable(variable));
    }

    public QCategory(Path<? extends Category> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCategory(PathMetadata metadata) {
        super(Category.class, metadata);
    }

}

