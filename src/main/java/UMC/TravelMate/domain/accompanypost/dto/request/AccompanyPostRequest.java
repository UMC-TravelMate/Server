package UMC.TravelMate.domain.accompanypost.dto.request;

import UMC.TravelMate.domain.accompanypost.enums.AccompanionType;
import UMC.TravelMate.domain.accompanypost.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AccompanyPostRequest {
    @Getter
    public static class AccompanyPostCreateRequestDTO {

        @Size(max = 20) // 제목 20자 설정
        @NotBlank
        private String title;

        @NotBlank
        private String destination;

        @NotBlank
        private String content;

        @NotNull
        private LocalDate startAt;

        @NotNull
        private LocalDate endAt;

        @NotBlank
        private String language;

        @Size(min = 1)
        private Integer minAge;


        private Integer maxAge;

        @NotNull
        private Gender gender;

        @NotNull
        private AccompanionType accompanionType;

        @NotNull
        private Integer minParticipants;

        @NotNull
        private Integer maxParticipants;
    }

    @Getter
    public static class AccompanyPostUpdateRequestDTO {

        @Size(max = 20)
        @NotBlank
        private String title;

        @NotBlank
        private String destination;

        @NotBlank
        private String content;

        @NotNull
        private LocalDate startAt;

        @NotNull
        private LocalDate endAt;

        @NotBlank
        private String language;

        @Size(min = 1)
        private Integer minAge;


        private Integer maxAge;

        @NotNull
        private Gender gender;

        @NotNull
        private AccompanionType accompanionType;

        @NotNull
        private Integer minParticipants;

        @NotNull
        private Integer maxParticipants;


    }
}
