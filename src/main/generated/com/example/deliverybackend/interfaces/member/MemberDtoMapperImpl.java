package com.example.deliverybackend.interfaces.member;

import com.example.deliverybackend.domain.member.MemberCommand.LoginRequest;
import com.example.deliverybackend.domain.member.MemberCommand.ModifyMember;
import com.example.deliverybackend.interfaces.member.MemberDto.CheckPassword;
import com.example.deliverybackend.interfaces.member.MemberDto.CreateMemberRequest;
import com.example.deliverybackend.interfaces.member.MemberDto.LoginMemberRequest;
import com.example.deliverybackend.interfaces.member.MemberDto.ModifyMemberRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-18T22:29:40+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class MemberDtoMapperImpl implements MemberDtoMapper {

    @Override
    public com.example.deliverybackend.domain.member.MemberCommand.CreateMemberRequest of(CreateMemberRequest createMemberRequest) {
        if ( createMemberRequest == null ) {
            return null;
        }

        com.example.deliverybackend.domain.member.MemberCommand.CreateMemberRequest createMemberRequest1 = new com.example.deliverybackend.domain.member.MemberCommand.CreateMemberRequest();

        createMemberRequest1.setEmail( createMemberRequest.getEmail() );
        createMemberRequest1.setPassword( createMemberRequest.getPassword() );
        createMemberRequest1.setNickName( createMemberRequest.getNickName() );
        createMemberRequest1.setPhoneNumber( createMemberRequest.getPhoneNumber() );

        createMemberRequest1.setLocation( createMemberRequest.setPoint() );

        return createMemberRequest1;
    }

    @Override
    public LoginRequest of(LoginMemberRequest loginMemberRequest) {
        if ( loginMemberRequest == null ) {
            return null;
        }

        LoginRequest loginRequest = new LoginRequest();

        loginRequest.setEmail( loginMemberRequest.getEmail() );
        loginRequest.setPassword( loginMemberRequest.getPassword() );

        return loginRequest;
    }

    @Override
    public com.example.deliverybackend.domain.member.MemberCommand.CheckPassword of(Long memberId, CheckPassword checkPassword) {
        if ( memberId == null && checkPassword == null ) {
            return null;
        }

        com.example.deliverybackend.domain.member.MemberCommand.CheckPassword checkPassword1 = new com.example.deliverybackend.domain.member.MemberCommand.CheckPassword();

        if ( memberId != null ) {
            checkPassword1.setMemberId( memberId );
        }
        if ( checkPassword != null ) {
            checkPassword1.setPassword( checkPassword.getPassword() );
        }

        return checkPassword1;
    }

    @Override
    public ModifyMember of(Long memberId, ModifyMemberRequest modifyMemberRequest) {
        if ( memberId == null && modifyMemberRequest == null ) {
            return null;
        }

        ModifyMember modifyMember = new ModifyMember();

        if ( memberId != null ) {
            modifyMember.setMemberId( memberId );
        }
        if ( modifyMemberRequest != null ) {
            modifyMember.setEncodedKey( modifyMemberRequest.getEncodedKey() );
            modifyMember.setNickName( modifyMemberRequest.getNickName() );
            modifyMember.setPhoneNumber( modifyMemberRequest.getPhoneNumber() );
        }

        return modifyMember;
    }
}
