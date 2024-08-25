package com.example.deliverybackend.domain.member.entity;

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
@Table(name = "member")
public class Member extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;
    private String nickName;
    private String phoneNumber;
    @Column(name = "location", columnDefinition = "geography(Point, 4326)")
    private Point location;
}
