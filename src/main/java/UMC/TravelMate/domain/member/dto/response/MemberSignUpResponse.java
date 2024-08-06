package UMC.TravelMate.domain.member.dto.response;


import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MemberSignUpResponse {
    private Long id;
    private String email;
    private String password;
}
