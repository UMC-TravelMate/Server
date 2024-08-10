package UMC.TravelMate.domain.accompanypost.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class AccompanyPostResponse {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AccompanyPostCreateResponseDTO {
        Long accompanyPostId;
        LocalDate createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AccompanyPostDeleteResponseDTO {
        Long accompanyPostId;
        LocalDate deletedAt;
    }

}
