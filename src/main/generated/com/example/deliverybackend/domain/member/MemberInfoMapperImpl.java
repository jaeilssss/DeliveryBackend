package com.example.deliverybackend.domain.member;

import com.example.deliverybackend.domain.member.entity.Member;
import com.example.deliverybackend.domain.member.info.MemberInfo.Main;
import com.example.deliverybackend.domain.member.info.MemberInfo.Main.MainBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-18T22:29:40+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class MemberInfoMapperImpl implements MemberInfoMapper {

    @Override
    public Main of(Member member) {
        if ( member == null ) {
            return null;
        }

        MainBuilder main = Main.builder();

        main.id( member.getId() );
        main.email( member.getEmail() );
        main.nickName( member.getNickName() );
        main.phoneNumber( member.getPhoneNumber() );

        return main.build();
    }
}
