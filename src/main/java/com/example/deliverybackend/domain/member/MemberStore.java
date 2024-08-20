package com.example.deliverybackend.domain.member;

import com.example.deliverybackend.domain.member.entity.Member;

public interface MemberStore {

    Member store(Member member);
}
