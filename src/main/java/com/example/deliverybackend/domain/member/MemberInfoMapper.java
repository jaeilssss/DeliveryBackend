package com.example.deliverybackend.domain.member;

import com.example.deliverybackend.domain.member.entity.Member;
import com.example.deliverybackend.domain.member.info.MemberInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.*;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface MemberInfoMapper {

    MemberInfo.Main of(Member member);
}
