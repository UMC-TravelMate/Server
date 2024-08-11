package UMC.TravelMate.domain.review.service;

import UMC.TravelMate.domain.review.dto.request.ReviewRequest.ReviewCreateRequestDto;
import UMC.TravelMate.domain.review.dto.request.ReviewRequest.ReviewUpdateRequest;
import UMC.TravelMate.domain.review.dto.response.ReviewResponse.ReviewCreateResponseDTO;
import UMC.TravelMate.domain.review.dto.response.ReviewResponse.ReviewDeleteResponseDTO;
import UMC.TravelMate.domain.review.dto.response.ReviewInquiryResponse;
import UMC.TravelMate.domain.review.dto.response.ReviewUpdateResponse;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    ReviewCreateResponseDTO createReview(ReviewCreateRequestDto reviewCreateRequestDto);
    List<ReviewInquiryResponse> getAllReviews();
    Optional<ReviewInquiryResponse> getReviewById(Long id);
    ReviewUpdateResponse updateReview(Long id, ReviewUpdateRequest reviewUpdateRequest);
    ReviewDeleteResponseDTO deleteReview(Long id);
}