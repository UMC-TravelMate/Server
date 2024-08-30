package UMC.TravelMate.domain.member.dto.request;

import UMC.TravelMate.domain.member.entity.Gender;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

public class MemberRequest {

    @Builder
    @Getter
    public static class MemberSignUpDto{
        private String email;
        private String password;
        private String name;
        private LocalDate birth;
        private Gender gender;
        private String introduce;
        //private int code;
    }

    @Builder
    @Getter
    public static class LoginRequestDto{
        private String email;
        private String password;
    }


}
