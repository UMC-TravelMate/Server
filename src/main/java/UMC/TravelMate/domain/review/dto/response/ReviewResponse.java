package UMC.TravelMate.domain.review.dto.response;

import lombok.Getter;
import lombok.Setter;

public class ReviewResponse {

    @Getter
    @Setter
    public static class ReviewCreateResponseDTO {
        private Long id;
        private String content;
        private Long memberId;
        private Long postId;
        private Long parentReviewId;
    }

    @Getter
    @Setter
    public static class ReviewDeleteResponseDTO {
        private Long id;
        private String message;
    }
}
