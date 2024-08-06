package UMC.TravelMate.domain.member.service;

import UMC.TravelMate.config.jwt.JwtToken;
import UMC.TravelMate.domain.member.entity.Member;

public interface AuthService {
    JwtToken getToken(Member member);

    Long getLoginMemberId();

    Member getLoginMember();
}
