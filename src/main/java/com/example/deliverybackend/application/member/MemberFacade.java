package com.example.deliverybackend.application.member;

import com.example.deliverybackend.domain.member.MemberCommand;
import com.example.deliverybackend.domain.member.Service.MemberService;
import com.example.deliverybackend.domain.member.info.MemberInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberFacade {
    private final MemberService memberService;

    public Boolean signUp(MemberCommand.CreateMemberRequest createMemberRequest) {

        return memberService.signUp(createMemberRequest);
    }

    public MemberInfo.Main getMemberInfo(Long memberId) {
        return memberService.getMemberInfo(memberId);
    }

    public MemberInfo.Login login(MemberCommand.LoginRequest loginRequest) {
        return memberService.login(loginRequest);
    }

    public String checkPasswordBeforeModifyMember(MemberCommand.CheckPassword checkPassword) throws Exception {
        return memberService.checkPassword(checkPassword);
    }

    public Boolean modifyMember(MemberCommand.ModifyMember modifyMember) {
        return memberService.modifyMember(modifyMember);
    }
}
