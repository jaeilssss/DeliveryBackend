package com.example.deliverybackend.interfaces.member;

import com.example.deliverybackend.domain.member.MemberCommand;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface MemberDtoMapper {

    @Mappings({
            @Mapping(expression = "java(createMemberRequest.setPoint())", target = "location")
    })
    MemberCommand.CreateMemberRequest of(MemberDto.CreateMemberRequest createMemberRequest);
    MemberCommand.LoginRequest of(MemberDto.LoginMemberRequest loginMemberRequest);

    MemberCommand.CheckPassword of(Long memberId, MemberDto.CheckPassword checkPassword);
    MemberCommand.ModifyMember of (Long memberId, MemberDto.ModifyMemberRequest modifyMemberRequest);
}
