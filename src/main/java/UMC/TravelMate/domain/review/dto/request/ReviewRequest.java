package UMC.TravelMate.domain.review.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequest {

    @Getter
    @Setter
    public static class ReviewCreateRequestDto {
        private Long memberId;
        private Long postId;
        private Long parentReviewId;
        private String content;
    }

    @Getter
    @Setter
    public static class ReviewUpdateRequest {
        private String content;
    }
}
