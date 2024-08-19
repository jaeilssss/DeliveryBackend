package com.example.deliverybackend.infrastructure.member;

import com.example.deliverybackend.domain.member.entity.Member;
import com.example.deliverybackend.domain.member.entity.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MemberRepositoryCustomImpl implements MemberRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    public MemberRepositoryCustomImpl(EntityManager entityManager) {
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        QMember member = QMember.member;
        return Optional.ofNullable(jpaQueryFactory.selectFrom(member)
                .where(member.email.eq(email))
                .fetchOne());
    }

    @Override
    public Optional<Member> findByNickName(String nickName) {
        QMember member = QMember.member;
        return Optional.ofNullable(jpaQueryFactory.selectFrom(member)
                .where(member.nickName.eq(nickName))
                .fetchOne());
    }
}
