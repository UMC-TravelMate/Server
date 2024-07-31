package UMC.TravelMate.domain.accompanypost.dto.response;

import UMC.TravelMate.domain.accompanypost.enums.AccompanionType;
import UMC.TravelMate.domain.accompanypost.enums.Gender;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class AccompanyPostInquiryResponse {
    private Long accompanyPostId; // 게시글의 ID
    private String title;        // 게시글 제목
    private String content;      // 게시글 내용
    private String destination; // 여행 목표지
    private LocalDate startAt;   // 시작 날짜
    private LocalDate endAt;     // 종료 날짜
    private String language;     // 사용 언어
    private Integer minAge;      // 최소 나이
    private Integer maxAge;      // 최대 나이
    private Gender gender;       // 성별
    private AccompanionType accompanionType; // 동행 유형
    private Integer minParticipants; // 최소 참여 인원
    private Integer maxParticipants; // 최대 참여 인원
    private Integer currentParticipants; // 현재 참여 인원
    private Boolean isConfirmed; // 승인 여부
    //private LocalDate createdAt; // 생성 날짜
}
