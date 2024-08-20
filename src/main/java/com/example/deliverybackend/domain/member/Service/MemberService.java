package com.example.deliverybackend.domain.member.Service;

import com.example.deliverybackend.domain.member.MemberCommand;
import com.example.deliverybackend.domain.member.info.MemberInfo;

public interface MemberService {
    public Boolean signUp(MemberCommand.CreateMemberRequest createMemberRequest);
    public MemberInfo.Main getMemberInfo(Long memberId);
    public MemberInfo.Login login(MemberCommand.LoginRequest loginRequest);
    public String checkPassword(MemberCommand.CheckPassword checkPassword) throws Exception;

    public Boolean modifyMember(MemberCommand.ModifyMember modifyMember);

}
