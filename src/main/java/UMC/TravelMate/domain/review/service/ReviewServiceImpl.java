package UMC.TravelMate.domain.review.service.impl;

import UMC.TravelMate.domain.review.dto.request.ReviewRequest.ReviewCreateRequestDto;
import UMC.TravelMate.domain.review.dto.request.ReviewRequest.ReviewUpdateRequest;
import UMC.TravelMate.domain.review.dto.response.ReviewInquiryResponse;
import UMC.TravelMate.domain.review.dto.response.ReviewResponse.ReviewCreateResponseDTO;
import UMC.TravelMate.domain.review.dto.response.ReviewResponse.ReviewDeleteResponseDTO;
import UMC.TravelMate.domain.review.dto.response.ReviewUpdateResponse;
import UMC.TravelMate.domain.review.entity.Review;
import UMC.TravelMate.domain.review.repository.ReviewRepository;
import UMC.TravelMate.domain.review.service.ReviewService;
import UMC.TravelMate.domain.member.entity.Member;
import UMC.TravelMate.domain.post.entity.Post;
import UMC.TravelMate.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public ReviewCreateResponseDTO createReview(ReviewCreateRequestDto reviewCreateRequestDto) {
        Review review = new Review();
        review.setMember(new Member(reviewCreateRequestDto.getMemberId()));
        review.setPost(new Post(reviewCreateRequestDto.getPostId()));
        if (reviewCreateRequestDto.getParentReviewId != null) {
            review.setParentReview(new Review(reviewCreateRequestDto.getParentReviewId()));
        }
        review.setContent(reviewCreateRequestDto.getContent());
        Review savedReview = reviewRepository.save(review);
        return convertToCreateResponse(savedReview);
    }

    @Override
    public List<ReviewInquiryResponse> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().map(this::convertToInquiryResponse).collect(Collectors.toList());
    }

    @Override
    public Optional<ReviewInquiryResponse> getReviewById(Long id) {
        return reviewRepository.findById(id).map(this::convertToInquiryResponse);
    }

    @Override
    public ReviewUpdateResponse updateReview(Long id, ReviewUpdateRequest reviewUpdateRequest) {
        Review review = reviewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Review", "id", id));
        review.setContent(reviewUpdateRequest.getContent());
        Review updatedReview = reviewRepository.save(review);
        return convertToUpdateResponse(updatedReview);
    }

    @Override
    public ReviewDeleteResponseDTO deleteReview(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Review", "id", id));
        reviewRepository.delete(review);
        return new ReviewDeleteResponseDTO(id, "Review deleted successfully");
    }

    private ReviewInquiryResponse convertToInquiryResponse(Review review) {
        ReviewInquiryResponse response = new ReviewInquiryResponse();
        response.setId(review.getId());
        response.setMemberId(review.getMember().getId());
        response.setPostId(review.getPost().getId());
        response.setParentReviewId(review.getParentReview() != null ? review.getParentReview().getId() : null);
        response.setContent(review.getContent());
        response.setChildReviews(review.getChildReviews().stream().map(this::convertToInquiryResponse).collect(Collectors.toList()));
        return response;
    }

    private ReviewCreateResponseDTO convertToCreateResponse(Review review) {
        ReviewCreateResponseDTO response = new ReviewCreateResponseDTO();
        response.setId(review.getId());
        response.setMemberId(review.getMember().getId());
        response.setPostId(review.getPost().getId());
        response.setParentReviewId(review.getParentReview() != null ? review.getParentReview().getId() : null);
        response.setContent(review.getContent());
        return response;
    }

    private ReviewUpdateResponse convertToUpdateResponse(Review review) {
        ReviewUpdateResponse response = new ReviewUpdateResponse();
        response.setId(review.getId());
        response.setMemberId(review.getMember().getId());
        response.setPostId(review.getPost().getId());
        response.setParentReviewId(review.getParentReview() != null ? review.getParentReview().getId() : null);
        response.setContent(review.getContent());
        return response;
    }
}
