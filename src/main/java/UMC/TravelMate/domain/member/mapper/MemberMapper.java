package UMC.TravelMate.domain.member.mapper;

import UMC.TravelMate.config.jwt.JwtToken;
import UMC.TravelMate.domain.member.dto.response.MemberLoginResponse;
import UMC.TravelMate.domain.member.dto.response.MemberProfileResponse;
import UMC.TravelMate.domain.member.dto.response.MemberSignUpResponse;
import UMC.TravelMate.domain.member.entity.LoginType;
import UMC.TravelMate.domain.member.entity.Member;
import UMC.TravelMate.domain.member.entity.Role;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemberMapper {
    public Member toMember(String clientId, LoginType loginType) {
        return Member.builder()
                .clientId(clientId)
                .loginType(loginType)
                .role(Role.USER)
                .build();
    }

    public MemberLoginResponse toMemberLoginResponse(Long memberId, JwtToken jwtToken) {
        return MemberLoginResponse.builder()
                .memberId(memberId)
                .accessToken(jwtToken.getAccessToken())
                .refreshToken(jwtToken.getRefreshToken())
                .build();
    }

    public MemberSignUpResponse toMemberSignUpResponse(Long memberId, String email){
        return MemberSignUpResponse.builder()
                .id(memberId)
                .email(email)
                .build();
    }

    public MemberProfileResponse toMemberProfileResponse(Member member, int age){
        return MemberProfileResponse.builder()
                .name(member.getName())
                .age(age)
                .introduce(member.getIntroduce())
                .gender(member.getGender())
                .build();
    }


}
