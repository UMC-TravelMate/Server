package UMC.TravelMate.domain.member.repository;

import UMC.TravelMate.domain.member.entity.LoginType;
import UMC.TravelMate.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
    Optional<Member> findByClientIdAndLoginType(String clientId, LoginType loginType);
}
