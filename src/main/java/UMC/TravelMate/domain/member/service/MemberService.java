package UMC.TravelMate.domain.member.service;

import UMC.TravelMate.domain.member.dto.request.MemberRequest;
import UMC.TravelMate.domain.member.dto.response.MemberLoginResponse;
import UMC.TravelMate.domain.member.dto.response.MemberProfileResponse;
import UMC.TravelMate.domain.member.dto.response.MemberSignUpResponse;

public interface MemberService {
    MemberLoginResponse saveMemberByNaver(String accessToken);
    MemberLoginResponse saveMemberByKakao(String accessToken);
    MemberLoginResponse saveMemberByGoogle(String accessToken);
    MemberSignUpResponse signUpMember(MemberRequest.MemberSignUpDto request);
    MemberLoginResponse login(MemberRequest.LoginRequestDto request);

    MemberProfileResponse getMemberProfile();
}
