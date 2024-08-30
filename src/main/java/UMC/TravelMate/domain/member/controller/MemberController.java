package UMC.TravelMate.domain.member.controller;

import UMC.TravelMate.domain.member.dto.request.MemberRequest;
import UMC.TravelMate.domain.member.dto.response.MemberLoginResponse;
import UMC.TravelMate.domain.member.dto.response.MemberProfileResponse;
import UMC.TravelMate.domain.member.dto.response.MemberSignUpResponse;
import UMC.TravelMate.domain.member.service.MemberService;
import UMC.TravelMate.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "멤버 API", description = "멤버 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @Operation(summary = "구글 로그인 API")
    @PostMapping("/google")
    public BaseResponse<MemberLoginResponse> saveMemberByGoogle(@RequestParam(name = "accessToken") String accessToken) {
        return BaseResponse.onSuccess(memberService.saveMemberByGoogle(accessToken));
    }

    @Operation(summary = "카카오 로그인 API")
    @PostMapping("/kakao")
    public BaseResponse<MemberLoginResponse> saveMemberByKakao(@RequestParam(name = "accessToken") String accessToken) {
        return BaseResponse.onSuccess(memberService.saveMemberByKakao(accessToken));
    }

    @Operation(summary = "네이버 로그인 API")
    @PostMapping("/naver")
    public BaseResponse<MemberLoginResponse> saveMemberByNaver(@RequestParam(name = "accessToken") String accessToken) {
        return BaseResponse.onSuccess(memberService.saveMemberByNaver(accessToken));
    }

    @Operation(summary = "이메일 로그인 API")
    @PostMapping("/login")
    public BaseResponse<MemberLoginResponse> login(@RequestBody MemberRequest.LoginRequestDto request) {
        return BaseResponse.onSuccess(memberService.login(request));
    }

    @Operation(summary="이메일 회원가입")
    @PostMapping("/signup")
    public BaseResponse<MemberSignUpResponse> signUpMember(@RequestBody MemberRequest.MemberSignUpDto request) {
        return BaseResponse.onSuccess(memberService.signUpMember(request));
    }

    @Operation(summary="유저 프로필 조회")
    @GetMapping("/profile")
    public BaseResponse<MemberProfileResponse> getMemberProfile(){
        return BaseResponse.onSuccess(memberService.getMemberProfile());
    }

}