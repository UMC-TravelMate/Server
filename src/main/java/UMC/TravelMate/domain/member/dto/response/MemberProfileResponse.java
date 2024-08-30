package UMC.TravelMate.domain.member.dto.response;


import UMC.TravelMate.domain.member.entity.Gender;
import lombok.Builder;
import lombok.Getter;



@Getter
@Builder
public class MemberProfileResponse {
    private String name;
    private int age;
    private String introduce;
    private Gender gender;
    //private favoriteVacation;
}
