package UMC.TravelMate.domain.accompanypost.service;

import UMC.TravelMate.domain.accompanypost.dto.request.AccompanyPostRequest;
import UMC.TravelMate.domain.accompanypost.dto.response.AccompanyPostInquiryResponse;
import UMC.TravelMate.domain.accompanypost.dto.response.AccompanyPostResponse;
import UMC.TravelMate.domain.accompanypost.dto.response.AccompanyPostUpdateResponse;
import UMC.TravelMate.domain.accompanypost.entity.AccompanyPost;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public interface AccompanyPostService {

    //동행게시글 생성
    AccompanyPostResponse.AccompanyPostCreateResponseDTO createAccompanyPost(AccompanyPostRequest.AccompanyPostCreateRequestDTO request);
    
    //동행게시글 삭제
    Long deleteAccompanyPost(Long accompanyPostId);

    //동행게시글 수정
    AccompanyPostUpdateResponse updateAccompanyPost(Long accompanyPostId, AccompanyPostRequest.AccompanyPostUpdateRequestDTO request);

    //모든 동행게시글 조회
    Page<AccompanyPostInquiryResponse> inquiryAccompanyPostPage(Integer page);

    // 여행 여정 조회
    Page<AccompanyPostInquiryResponse> inquiryAccompanyPostByTravelPeriod(
            LocalDate startDate,
            LocalDate endDate,
            String destination,
            Integer page
    );

    // 최근 게시글 조회 -> 동행게시글 조회랑 비슷 (보류)
    //Page<AccompanyPostInquiryResponse> inquiryAccompanyPostByRecent(Integer page);

    // 조건에 맞는 게시글 조회 -> 후에 디테일 추가
    Page<AccompanyPostInquiryResponse> inquiryAccompanyPostByKeyword(String keyword, Integer page);

    // 조건에 맞는 게시글 조회 - 참가자 범위
    //Page<AccompanyPostInquiryResponse> inquiryAccompanyPostByParticipantRange(Integer participants, Integer page);
}
