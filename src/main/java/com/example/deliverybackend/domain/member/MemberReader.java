package com.example.deliverybackend.domain.member;

public interface MemberReader {

    public boolean checkIsExistEmail(String email);
    public boolean checkIsExistNickName(String nickname);

    public Member getMemberByEmail(String email);
    public Member getMemberByMemberId(Long id);

    public Member getMemberByNickname(String nickName);
    public Member getMemberById(Long memberId);
}
