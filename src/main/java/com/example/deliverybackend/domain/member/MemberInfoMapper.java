package com.example.deliverybackend.domain.member;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.*;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface MemberInfoMapper {

    MemberInfo.Main of(Member member);
}
