package UMC.TravelMate.domain.member.dto.request;

import lombok.*;

import java.util.List;

public class MemberRequest {

    @Builder
    @Getter
    public static class MemberSignUpDto{
        private String email;
        private String password;
        //private int code;
    }

    @Builder
    @Getter
    public static class LoginRequestDto{
        private String email;
        private String password;
    }


}
