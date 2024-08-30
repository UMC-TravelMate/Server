package UMC.TravelMate.domain.member.service;

import UMC.TravelMate.config.jwt.JwtToken;
import UMC.TravelMate.config.jwt.JwtTokenProvider;
import UMC.TravelMate.domain.member.client.GoogleMemberClient;
import UMC.TravelMate.domain.member.client.KakaoMemberClient;
import UMC.TravelMate.domain.member.client.NaverMemberClient;
import UMC.TravelMate.domain.member.dto.request.MemberRequest;
import UMC.TravelMate.domain.member.dto.response.MemberLoginResponse;
import UMC.TravelMate.domain.member.dto.response.MemberProfileResponse;
import UMC.TravelMate.domain.member.dto.response.MemberSignUpResponse;
import UMC.TravelMate.domain.member.entity.LoginType;
import UMC.TravelMate.domain.member.entity.Member;
import UMC.TravelMate.domain.member.entity.Role;
import UMC.TravelMate.domain.member.mapper.MemberMapper;
import UMC.TravelMate.domain.member.repository.MemberRepository;
import UMC.TravelMate.global.exception.CustomApiException;
import UMC.TravelMate.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;
    private final NaverMemberClient naverMemberClient;
    private final KakaoMemberClient kakaoMemberClient;
    private final GoogleMemberClient googleMemberClient;
    private final AuthService authService;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;


    @Override
    @Transactional
    public MemberLoginResponse saveMemberByNaver(final String accessToken) {
        String clientId = getNaverClientId(accessToken);
        Optional<Member> member = memberRepository.findByClientIdAndLoginType(clientId, LoginType.NAVER);
        if(member.isPresent()) {
            return getMemberLoginResponse(member.get());
        }
        return getNewMemberLoginResponse(clientId, LoginType.NAVER);
    }

    @Override
    @Transactional
    public MemberLoginResponse saveMemberByKakao(String accessToken) {
        String clientId = getKakaoClientId(accessToken);
        Optional<Member> member = memberRepository.findByClientIdAndLoginType(clientId, LoginType.KAKAO);
        if(member.isPresent()) {
            return getMemberLoginResponse(member.get());
        }
        return getNewMemberLoginResponse(clientId, LoginType.KAKAO);
    }

    @Override
    @Transactional
    public MemberLoginResponse saveMemberByGoogle(String accessToken) {
        String clientId = getGoogleClientId(accessToken);
        Optional<Member> member = memberRepository.findByClientIdAndLoginType(clientId, LoginType.GOOGLE);
        if(member.isPresent()) {
            return getMemberLoginResponse(member.get());
        }
        return getNewMemberLoginResponse(clientId, LoginType.GOOGLE);
    }

    @Override
    @Transactional
    public MemberSignUpResponse signUpMember(MemberRequest.MemberSignUpDto request) {

        Optional <Member> findMember = memberRepository.findByEmail(request.getEmail());

        if (findMember.isPresent()){
            throw new CustomApiException(ErrorCode.DUPLICATE_EMAIL);
        }
        
        //mapper로 바꾸기
        Member member = Member.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .name(request.getName())
                .birth(request.getBirth())
                .gender(request.getGender())
                .introduce(request.getIntroduce())
                .role(Role.USER)
                .build();

        memberRepository.save(member);

        return memberMapper.toMemberSignUpResponse(member.getId(), request.getEmail());
    }

    @Override
    @Transactional
    public MemberLoginResponse login(MemberRequest.LoginRequestDto request){
        String email = request.getEmail();
        String password = request.getPassword();

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(email, password);

        Authentication authentication =
                authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        String authenticatedUserId = authentication.getName(); //  UserId

        Member member = memberRepository.findById(Long.valueOf(authenticatedUserId))
                .orElseThrow(() -> new CustomApiException(ErrorCode.USER_NOT_FOUND)); // id
        JwtToken jwtToken = jwtTokenProvider.generateToken(member.getId().toString());

        return memberMapper.toMemberLoginResponse(member.getId(), jwtToken);
    }

    @Override
    @Transactional
    public MemberProfileResponse getMemberProfile(){
        Member member = authService.getLoginMember();

        LocalDate currentDate = LocalDate.now();
        int age = Period.between(member.getBirth(), currentDate).getYears();

        return memberMapper.toMemberProfileResponse(member,age);
    }


    private String getNaverClientId(final String accessToken) {
        return naverMemberClient.getNaverUserId(accessToken);
    }

    private String getKakaoClientId(final String accessToken) {
        return kakaoMemberClient.getKakaoUserId(accessToken);
    }

    private String getGoogleClientId(final String accessToken) {
        return googleMemberClient.getGoogleUserId(accessToken);
    }

    private MemberLoginResponse getMemberLoginResponse(final Member member) {
        // TODO RefreshToken으로 AccessToken만 재발급 받도록 구현
        JwtToken jwtToken = authService.getToken(member);
        return memberMapper.toMemberLoginResponse(member.getId(), jwtToken);
    }

    private MemberLoginResponse getNewMemberLoginResponse(final String clientId, final LoginType loginType) {
        Member member = memberRepository.save(memberMapper.toMember(clientId, loginType));
        JwtToken jwtToken = authService.getToken(member);
        return memberMapper.toMemberLoginResponse(member.getId(), jwtToken);
    }
}
