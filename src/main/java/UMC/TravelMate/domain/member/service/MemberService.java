package UMC.TravelMate.domain.member.service;

import UMC.TravelMate.domain.member.dto.request.MemberRequest;
import UMC.TravelMate.domain.member.dto.response.MemberLoginResponse;
import UMC.TravelMate.domain.member.dto.response.MemberSignUpResponse;
import UMC.TravelMate.domain.member.entity.Member;

import java.util.List;

public interface MemberService {
    MemberLoginResponse saveMemberByNaver(String accessToken);
    MemberLoginResponse saveMemberByKakao(String accessToken);
    MemberLoginResponse saveMemberByGoogle(String accessToken);

    public MemberSignUpResponse signUpMember(String email, String password);

    public MemberLoginResponse login(MemberRequest.LoginRequestDto request);

}
