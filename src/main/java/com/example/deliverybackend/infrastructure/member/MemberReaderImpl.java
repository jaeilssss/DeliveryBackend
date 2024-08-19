package com.example.deliverybackend.infrastructure.member;

import com.example.deliverybackend.domain.member.MemberReader;
import com.example.deliverybackend.domain.member.entity.Member;
import com.example.deliverybackend.globals.exception.BaseException;
import com.example.deliverybackend.globals.exception.ErrorCode.MemberErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class MemberReaderImpl implements MemberReader {
    private final MemberRepository memberRepository;


    @Override
    public boolean checkIsExistEmail(String email) {
         memberRepository.findByEmail(email)
                .ifPresent(member -> {
                    throw new BaseException(MemberErrorCode.EXIST_EMAIL_ERROR.getErrorMsg());
                });
         return true;
    }

    @Override
    public boolean checkIsExistNickName(String nickname) {
        memberRepository.findByNickName(nickname)
                .ifPresent(member -> {
                    throw new BaseException(MemberErrorCode.EXIST_NICKNAME_ERROR.getErrorMsg());
                });
        return true;
    }

    @Override
    public Member getMemberByEmail(String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(() -> new BaseException(MemberErrorCode.MEMBER_NOT_FOUND_ERROR.getErrorMsg()));
    }

    @Override
    public Member getMemberByMemberId(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new BaseException(MemberErrorCode.MEMBER_NOT_FOUND_ERROR.getErrorMsg()));
    }


    @Override
    public Member getMemberByNickname(String nickName) {
        return memberRepository.findByNickName(nickName)
                .orElseThrow(() -> new BaseException(MemberErrorCode.INVALID_REQUEST.getErrorMsg()));
    }

    @Override
    public Member getMemberById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new BaseException(MemberErrorCode.MEMBER_NOT_FOUND_ERROR.getErrorMsg()));
    }
}
