package com.example.deliverybackend.infrastructure.member;

import com.example.deliverybackend.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>,MemberRepositoryCustom {

}
