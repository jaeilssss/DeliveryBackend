package com.example.deliverybackend.infrastructure.member;

import com.example.deliverybackend.domain.member.MemberStore;
import com.example.deliverybackend.domain.member.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MemberStoreImpl implements MemberStore {
    private final MemberRepository memberRepository;
    @Override
    public Member store(Member member) {
        return memberRepository.save(member);
    }
}
