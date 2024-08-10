package UMC.TravelMate.domain.review.controller;

import UMC.TravelMate.domain.review.converter.ReviewConverter;
import UMC.TravelMate.domain.review.dto.request.ReviewRequest.ReviewCreateRequestDto;
import UMC.TravelMate.domain.review.dto.request.ReviewRequest.ReviewUpdateRequest;
import UMC.TravelMate.domain.review.dto.response.ReviewInquiryResponse;
import UMC.TravelMate.domain.review.dto.response.ReviewResponse.ReviewCreateResponseDTO;
import UMC.TravelMate.domain.review.dto.response.ReviewResponse.ReviewDeleteResponseDTO;
import UMC.TravelMate.domain.review.dto.response.ReviewUpdateResponse;
import UMC.TravelMate.domain.review.entity.Review;
import UMC.TravelMate.domain.review.service.ReviewService;
import UMC.TravelMate.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewCreateResponseDTO> createReview(@RequestBody ReviewCreateRequestDto reviewCreateRequestDto) {
        Review review = ReviewConverter.toEntity(reviewCreateRequestDto);
        ReviewCreateResponseDTO createdReview = reviewService.createReview(reviewCreateRequestDto);
        return ResponseEntity.ok(createdReview);
    }

    @GetMapping
    public ResponseEntity<List<ReviewInquiryResponse>> getAllReviews() {
        List<ReviewInquiryResponse> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewInquiryResponse> getReviewById(@PathVariable Long id) {
        Optional<ReviewInquiryResponse> reviewResponse = reviewService.getReviewById(id);
        return reviewResponse.map(ResponseEntity::ok).orElseThrow(() -> new ResourceNotFoundException("Review", "id", id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewUpdateResponse> updateReview(@PathVariable Long id, @RequestBody ReviewUpdateRequest reviewUpdateRequest) {
        ReviewUpdateResponse updatedReview = reviewService.updateReview(id, reviewUpdateRequest);
        return ResponseEntity.ok(updatedReview);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReviewDeleteResponseDTO> deleteReview(@PathVariable Long id) {
        ReviewDeleteResponseDTO response = reviewService.deleteReview(id);
        return ResponseEntity.ok(response);
    }
}
