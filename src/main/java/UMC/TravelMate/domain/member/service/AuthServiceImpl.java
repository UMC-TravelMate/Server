package UMC.TravelMate.domain.member.service;

import UMC.TravelMate.config.jwt.JwtToken;
import UMC.TravelMate.config.jwt.JwtTokenProvider;
import UMC.TravelMate.domain.member.entity.Member;
import UMC.TravelMate.domain.member.repository.MemberRepository;
import UMC.TravelMate.global.exception.CustomApiException;
import UMC.TravelMate.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthServiceImpl implements AuthService{

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional
    public JwtToken getToken(Member member) {
        JwtToken jwtToken = jwtTokenProvider.generateToken(member.getId().toString());
        member.saveRefreshToken(jwtToken.getRefreshToken());
        return jwtToken;
    }

    @Override
    public Long getLoginMemberId() {
        return Long.parseLong(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @Override
    public Member getLoginMember() {
        return memberRepository.findById(getLoginMemberId())
                .orElseThrow(() -> new CustomApiException(ErrorCode.USER_NOT_FOUND));
    }
}
