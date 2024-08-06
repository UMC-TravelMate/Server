package UMC.TravelMate.domain.member.entity;


import UMC.TravelMate.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Where(clause = "deleted_at is null")
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String clientId;

    private String password;

    private String name;

    private String phoneNumber;

    private LocalDate birth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private LoginType loginType;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String introduce; //자기소개

    private String refreshToken;

    /*@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberImage> images = new ArrayList<>();*/

    /*@OneToMany
    private List<favariteActive> favariteActives = new ArrayList<>();*/

    public void saveRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }


}
