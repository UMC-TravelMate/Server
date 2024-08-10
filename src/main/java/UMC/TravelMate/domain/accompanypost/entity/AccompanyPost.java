package UMC.TravelMate.domain.accompanypost.entity;

import UMC.TravelMate.domain.accompanypost.dto.request.AccompanyPostRequest;
import UMC.TravelMate.domain.accompanypost.enums.AccompanionType;
import UMC.TravelMate.domain.accompanypost.enums.Gender;
import UMC.TravelMate.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AccompanyPost extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String destination;

    @Enumerated(EnumType.STRING)
    private AccompanionType accompanionType;

    private LocalDate startAt;

    private LocalDate endAt;

    private String language;

    private Integer minAge;

    private Integer maxAge;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Integer minParticipants;

    private Integer maxParticipants;

    private Integer currentParticipants;

    private String content;

    private Boolean isConfirmed;

    public void update(String title, String destination, String content, LocalDate startAt, LocalDate endAt, String language, 
                       Integer minAge, Integer maxAge, Gender gender, AccompanionType accompanionType, Integer minParticipants, Integer maxParticipants) {
        
        this.title = title;
        this.destination = destination;
        this.content = content;
        this.startAt = startAt;
        this.endAt = endAt;
        this.language = language;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.gender = gender;
        this.accompanionType = accompanionType;
        this.minParticipants = minParticipants;
        this.maxParticipants = maxParticipants;
        updated();
    }

    //member ID 추가
    //@ManytoOne(fetch = FetchType.LAZY)
    //private Member member;

}
