package com.example.deliverybackend.infrastructure.member;

import com.example.deliverybackend.domain.member.entity.Member;

import java.util.Optional;

public interface MemberRepositoryCustom {
    Optional<Member> findByEmail(String email);
    Optional<Member> findByNickName(String nickName);
}
