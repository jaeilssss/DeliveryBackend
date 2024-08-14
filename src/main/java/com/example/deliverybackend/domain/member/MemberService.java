package com.example.deliverybackend.domain.member;

public interface MemberService {
    public Boolean signUp(MemberCommand.CreateMemberRequest createMemberRequest);
    public MemberInfo.Main getMemberInfo(Long memberId);
    public MemberInfo.Login login(MemberCommand.LoginRequest loginRequest);
    public String checkPassword(MemberCommand.CheckPassword checkPassword) throws Exception;

    public Boolean modifyMember(MemberCommand.ModifyMember modifyMember);

}
