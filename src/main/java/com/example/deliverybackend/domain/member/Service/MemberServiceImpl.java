package com.example.deliverybackend.domain.member.Service;

import com.example.deliverybackend.domain.member.*;
import com.example.deliverybackend.domain.member.entity.Member;
import com.example.deliverybackend.domain.member.info.MemberInfo;
import com.example.deliverybackend.globals.exception.BaseException;
import com.example.deliverybackend.globals.exception.ErrorCode.MemberErrorCode;
import com.example.deliverybackend.globals.jwt.JwtDto;
import com.example.deliverybackend.globals.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {
    private final MemberReader memberReader;
    private final MemberStore memberStore;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final MemberInfoMapper memberInfoMapper;


    private final static String shaAlg = "SHA-256";
    private final static String aesAlg = "AES/CBC/PKCS5Padding";
    private final static String key = "deliveryBackend!asddfghn";
    private final static String iv = key.substring(0, 16);


    @Override
    @Transactional
    public Boolean signUp(MemberCommand.CreateMemberRequest createMemberRequest) {
        // 이미 존재한 이메일인지 확인
        validateIsExistEmail(createMemberRequest.getEmail());

        // 이미 존재한 닉네임인지 확인
        validateIsExistNickName(createMemberRequest.getNickName());

        createMemberRequest.setPassword(passwordEncoder.encode(createMemberRequest.getPassword()));
        memberStore.store(createMemberRequest.toEntity());

        return true;
    }

    @Override
    public MemberInfo.Main getMemberInfo(Long memberId) {
        return memberInfoMapper.of(memberReader.getMemberById(memberId));
    }

    @Override
    public MemberInfo.Login login(MemberCommand.LoginRequest loginRequest) {
        Member member = memberReader.getMemberByEmail(loginRequest.getEmail());
        if(!passwordEncoder.matches(loginRequest.getPassword(), member.getPassword())){
            throw new BaseException(MemberErrorCode.INVALID_LOGIN_REQUEST.getErrorMsg());
        }
        JwtDto jwtDto = jwtProvider.createToken(member.getEmail(), member.getId());

        return MemberInfo.Login.builder()
                .accessToken(jwtDto.getAccessToken())
                .refreshToken(jwtDto.getRefreshToken())
                .build();
    }

    @Override
    public String checkPassword(MemberCommand.CheckPassword checkPassword) {
        try {
            Member member = memberReader.getMemberById(checkPassword.getMemberId());
            if(!passwordEncoder.matches(checkPassword.getPassword(), member.getPassword())) {
                throw new BaseException(MemberErrorCode.INCORRECT_PASSWORD.getErrorMsg());
            }
            //encrypt
            String shaKey = getShaKey(String.valueOf(checkPassword.getMemberId()));
            return getAesKey(shaKey);

        } catch (Exception e) {
            throw new RuntimeException("암호화 처리중에 에러가 발생했습니다. e = "+e.getMessage() );
        }
    }

    @Transactional
    @Override
    public Boolean modifyMember(MemberCommand.ModifyMember modifyMember) {
        if(!decrypt(modifyMember.getEncodedKey()).equals(String.valueOf(modifyMember.getMemberId()))) {
            throw new BaseException(MemberErrorCode.INVALID_REQUEST.getErrorMsg());
        }
        Member member = memberReader.getMemberById(modifyMember.getMemberId());
        member.setNickName(modifyMember.getNickName());
        member.setPhoneNumber(modifyMember.getPhoneNumber());
        return true;
    }

    private String getShaKey(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(shaAlg);
        md.update(text.getBytes());
        return bytesToHex(md.digest());
    }
    private String getAesKey(String text) throws Exception {
        Cipher cipher = Cipher.getInstance(aesAlg);
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParameterSpec);

        byte[] encodedBytes = cipher.doFinal(text.getBytes());
        byte[] encrypted = Base64.getEncoder().encode(encodedBytes);
        return new String(encrypted).trim();
    }
    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

    private String decrypt(String clientKey) {
        try {
            Cipher cipher = Cipher.getInstance(aesAlg);
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParameterSpec);


            byte[] decoedBytes = Base64.getDecoder().decode(clientKey.getBytes());
            byte[] decrypted = cipher.doFinal(decoedBytes);
            return new String(decrypted).trim();
        } catch (Exception e) {
            throw new RuntimeException("복호화 처리중에 에러가 발생했습니다. e = " + e.getMessage());
        }
    }
    public void validateIsExistEmail(String email) {
        memberReader.checkIsExistEmail(email);
    }

    public void validateIsExistNickName(String nickName) {
        memberReader.checkIsExistNickName(nickName);
    }
}
