package UMC.TravelMate.domain.review.dto.response;


import java.util.List;

public class ReviewInquiryResponse {
    private Long id;
    private Long memberId;
    private Long postId;
    private Long parentReviewId;
    private String content;
    private List<ReviewInquiryResponse> childReviews;
}