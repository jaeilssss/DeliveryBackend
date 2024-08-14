package com.example.deliverybackend.interfaces.member;

import com.example.deliverybackend.application.member.MemberFacade;
import com.example.deliverybackend.interfaces.BaseController;
import com.example.deliverybackend.interfaces.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/member")
public class MemberApiController extends BaseController{
    private final MemberFacade memberFacade;
    private final MemberDtoMapper memberDtoMapper;

    @PostMapping("/signup")
    public Response<Boolean> signUp(@RequestBody MemberDto.CreateMemberRequest createMemberRequest) {
        return Response.success(memberFacade.signUp(memberDtoMapper.of(createMemberRequest)));
    }

    @GetMapping("/{memberId}")
    public Response getMemberInfo(@PathVariable("memberId") @Valid Long memberId) {
        return Response.success(memberFacade.getMemberInfo(memberId));
    }

    @PostMapping("/login")
    public Response login(@RequestBody @Valid MemberDto.LoginMemberRequest loginMemberRequest) {
        return Response.success(memberFacade.login(memberDtoMapper.of(loginMemberRequest)));
    }

    @PostMapping("/modify/check/{memberId}")
    public Response checkPasswordBeforeModifyMember(
            @PathVariable("memberId") Long memberId,
            @RequestBody @Valid MemberDto.CheckPassword checkPassword) throws Exception {
        return Response.success(memberFacade.checkPasswordBeforeModifyMember(memberDtoMapper.of(memberId, checkPassword)));
    }
    @PutMapping("/{memberId}")
    public Response modifyMemberInfo(
            @PathVariable("memberId") @Valid Long memberId,
            @RequestBody @Valid MemberDto.ModifyMemberRequest modifyMemberRequest
    ) {
        return Response.success(memberFacade.modifyMember(memberDtoMapper.of(memberId, modifyMemberRequest)));
    }
}
