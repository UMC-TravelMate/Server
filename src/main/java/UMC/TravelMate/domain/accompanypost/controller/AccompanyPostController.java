package UMC.TravelMate.domain.accompanypost.controller;

import UMC.TravelMate.domain.accompanypost.converter.AccompanyPostConverter;
import UMC.TravelMate.domain.accompanypost.dto.request.AccompanyPostRequest;
import UMC.TravelMate.domain.accompanypost.dto.response.AccompanyPostInquiryResponse;
import UMC.TravelMate.domain.accompanypost.dto.response.AccompanyPostResponse;
import UMC.TravelMate.domain.accompanypost.dto.response.AccompanyPostUpdateResponse;
import UMC.TravelMate.domain.accompanypost.entity.AccompanyPost;
import UMC.TravelMate.domain.accompanypost.service.AccompanyPostService;
import UMC.TravelMate.global.common.BaseResponse;
import UMC.TravelMate.global.exception.CustomApiException;
import UMC.TravelMate.global.exception.ErrorCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accompanyposts")
public class AccompanyPostController {

    private final AccompanyPostService accompanyPostService;

    @PostMapping("/create")
    public BaseResponse<AccompanyPostResponse.AccompanyPostCreateResponseDTO> createAccompanyPost(@RequestBody @Valid AccompanyPostRequest.AccompanyPostCreateRequestDTO requset) {
        AccompanyPost newAccompanyPost = accompanyPostService.createAccompanyPost(requset);
        return BaseResponse.onSuccess(AccompanyPostConverter.toAccompanyPostCreateResponseDTO(newAccompanyPost));
    }

    @DeleteMapping("/delete/{accompanyPostId}")
    public BaseResponse<AccompanyPostResponse.AccompanyPostDeleteResponseDTO> deleteAccompanyPost(@PathVariable Long accompanyPostId) {
        Long deleteAccompanyPostId = accompanyPostService.deleteAccompanyPost(accompanyPostId);
        return BaseResponse.onSuccess(AccompanyPostConverter.toAccompanyPostDeleteResponseDTO(deleteAccompanyPostId));
    }

    @PatchMapping("/update/{accompanyPostId}")
    public BaseResponse<AccompanyPostUpdateResponse> updateAccompanyPost(
            @PathVariable Long accompanyPostId,
            @RequestBody @Valid AccompanyPostRequest.AccompanyPostUpdateRequestDTO request) {
        return BaseResponse.onSuccess(accompanyPostService.updateAccompanyPost(accompanyPostId, request));
    }

    @GetMapping("/search")
    public BaseResponse<Page<AccompanyPostInquiryResponse>> inquiryAccompanyPostPage(
            @RequestParam(name = "page") Integer page) {
        try {
            return BaseResponse.onSuccess(accompanyPostService.inquiryAccompanyPostPage(page));
        } catch (CustomApiException e){
            ErrorCode errorCode = e.getErrorCode();
            return BaseResponse.onFailure(errorCode.getCode(), errorCode.getMessage(), null);
        }
    }

    @GetMapping("/search/travel-period")
    public BaseResponse<Page<AccompanyPostInquiryResponse>> inquiryAccompanyPostByTravelPeriod(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate,
            @RequestParam(required = false) String destination,
            @RequestParam (name = "page") Integer page) {
        try {
           return BaseResponse.onSuccess(accompanyPostService.inquiryAccompanyPostByTravelPeriod(startDate, endDate, destination, page));
        } catch (CustomApiException e){
            ErrorCode errorCode = e.getErrorCode();
            return BaseResponse.onFailure(errorCode.getCode(), errorCode.getMessage(), null);
        }
    }

    @GetMapping("/search/keyword")
    public BaseResponse<Page<AccompanyPostInquiryResponse>> inquiryAccompanyPostByKeyword(
            @RequestParam String keyword,
            @RequestParam (name = "page") Integer page) {
        try {
            return BaseResponse.onSuccess(accompanyPostService.inquiryAccompanyPostByKeyword(keyword, page));
        } catch (CustomApiException e){
            ErrorCode errorCode = e.getErrorCode();
            return BaseResponse.onFailure(errorCode.getCode(), errorCode.getMessage(), null);
        }
    }


}
