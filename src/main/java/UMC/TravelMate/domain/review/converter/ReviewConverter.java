package UMC.TravelMate.domain.review.converter;

import UMC.TravelMate.domain.review.dto.request.ReviewRequest.ReviewCreateRequestDto;
import UMC.TravelMate.domain.review.dto.request.ReviewRequest.ReviewUpdateRequest;
import UMC.TravelMate.domain.review.dto.response.ReviewInquiryResponse;
import UMC.TravelMate.domain.review.dto.response.ReviewResponse.ReviewCreateResponseDTO;
import UMC.TravelMate.domain.review.dto.response.ReviewUpdateResponse;
import UMC.TravelMate.domain.review.entity.Review;
import UMC.TravelMate.domain.member.entity.Member;
import UMC.TravelMate.domain.post.entity.Post;

import java.util.stream.Collectors;

public class ReviewConverter {

    public static Review toEntity(ReviewCreateRequestDto dto) {
        Review review = new Review();
        review.setMember(new Member(dto.getMemberId()));
        review.setPost(new Post(dto.getPostId()));
        if (dto.getParentReviewId() != null) {
            review.setParentReview(new Review(dto.getParentReviewId()));
        }
        review.setContent(dto.getContent());
        return review;
    }

    public static ReviewCreateResponseDTO toCreateResponse(Review review) {
        ReviewCreateResponseDTO response = new ReviewCreateResponseDTO();
        response.setId(review.getId());
        response.setMemberId(review.getMember().getId());
        response.setPostId(review.getPost().getId());
        response.setParentReviewId(review.getParentReview() != null ? review.getParentReview().getId() : null);
        response.setContent(review.getContent());
        return response;
    }

    public static ReviewUpdateResponse toUpdateResponse(Review review) {
        ReviewUpdateResponse response = new ReviewUpdateResponse();
        response.setId(review.getId());
        response.setMemberId(review.getMember().getId());
        response.setPostId(review.getPost().getId());
        response.setParentReviewId(review.getParentReview() != null ? review.getParentReview().getId() : null);
        response.setContent(review.getContent());
        return response;
    }

    public static ReviewInquiryResponse toInquiryResponse(Review review) {
        ReviewInquiryResponse response = new ReviewInquiryResponse();
        response.setId(review.getId());
        response.setMemberId(review.getMember().getId());
        response.setPostId(review.getPost().getId());
        response.setParentReviewId(review.getParentReview() != null ? review.getParentReview().getId() : null);
        response.setContent(review.getContent());
        response.setChildReviews(review.getChildReviews().stream().map(ReviewConverter::toInquiryResponse).collect(Collectors.toList()));
        return response;
    }
}
