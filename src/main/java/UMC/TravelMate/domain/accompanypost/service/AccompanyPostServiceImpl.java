package UMC.TravelMate.domain.accompanypost.service;

import UMC.TravelMate.domain.accompanypost.converter.AccompanyPostConverter;
import UMC.TravelMate.domain.accompanypost.dto.request.AccompanyPostRequest;
import UMC.TravelMate.domain.accompanypost.dto.response.AccompanyPostInquiryResponse;
import UMC.TravelMate.domain.accompanypost.dto.response.AccompanyPostUpdateResponse;
import UMC.TravelMate.domain.accompanypost.entity.AccompanyPost;
import UMC.TravelMate.domain.accompanypost.repository.AccompanyPostRepository;
import UMC.TravelMate.global.exception.CustomApiException;
import UMC.TravelMate.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccompanyPostServiceImpl implements AccompanyPostService {

    private final AccompanyPostRepository accompanyPostRepository; //repository 추가
    private final AccompanyPostConverter accompanyPostConverter; // converter 추가

    // 동행게시글 생성
    @Override
    @Transactional
    public AccompanyPost createAccompanyPost(AccompanyPostRequest.AccompanyPostCreateRequestDTO request){
        //member 관련 혹은 추가내용시 작성
        AccompanyPost newAccompanyPost = AccompanyPostConverter.toAccompanyPost(request); // member 추가시 Converter 변환 필요

        return accompanyPostRepository.save(newAccompanyPost);
    }

    // 동행게시글 삭제
    @Override
    @Transactional
    public Long deleteAccompanyPost(Long accompanyPostId){
        // 내 게시글인지 유효성 검사 추가 + memberID

        AccompanyPost accompanyPost = accompanyPostRepository.findById(accompanyPostId)
                .orElseThrow(()-> new CustomApiException(ErrorCode.BAD_REQUEST)); // ErrorCode 설정

        Long deletedAccompanyPostId = accompanyPost.getId();
        accompanyPostRepository.deleteById(accompanyPost.getId());
        return deletedAccompanyPostId;
    }

    //동행게시글 수정
    @Override
    @Transactional
    public AccompanyPostUpdateResponse updateAccompanyPost(Long accompanyPostId, AccompanyPostRequest.AccompanyPostUpdateRequestDTO request){
        // 내 게시글인지 유효성 검사 추가 + memberID

        AccompanyPost accompanyPost = accompanyPostRepository.findById(accompanyPostId)
                .orElseThrow(()-> new CustomApiException(ErrorCode.BAD_REQUEST)); // ErrorCode 설정

        accompanyPost.update(request.getTitle(), request.getDestination(), request.getContent(), request.getStartAt(), request.getEndAt(),
                request.getLanguage(), request.getMinAge(), request.getMaxAge(), request.getGender(), request.getAccompanionType(), request.getMinParticipants(),
                request.getMaxParticipants());

        AccompanyPost updatedPost = accompanyPostRepository.save(accompanyPost);
        return accompanyPostConverter.toAccompanyPostUpdateResponse(updatedPost);
    }

    //모든 동행게시글 조회
    @Override
    @Transactional
    public Page<AccompanyPostInquiryResponse> inquiryAccompanyPostPage(Integer page){

        Page<AccompanyPost> accompanyPostPage = accompanyPostRepository.findAll(PageRequest.of(page-1,8, Sort.by("createdAt").descending())); // 생성된 순으로 내림차순

        return accompanyPostPage.map(accompanyPostConverter::toAccompanyPostInquiryResponse);
    }

    //여행여정 조회
    @Override
    @Transactional
    public Page<AccompanyPostInquiryResponse> inquiryAccompanyPostByTravelPeriod(LocalDate startDate, LocalDate endDate, String destination, Integer page) {
        // 여행 여정 및 선택적 목적지에 맞는 게시글을 조회
        Page<AccompanyPost> accompanyPostPage = accompanyPostRepository.findByTravelPeriodAndOptionalDestination(startDate, endDate, destination, PageRequest.of(page - 1, 12));
        // Entity를 DTO로 변환하여 반환
        return accompanyPostPage.map(accompanyPostConverter::toAccompanyPostInquiryResponse);
    }

    // 조건에 맞는 게시글 조회 (조건 후에 추가가능)
    @Override
    @Transactional(readOnly = true)
    public Page<AccompanyPostInquiryResponse> inquiryAccompanyPostByKeyword(String keyword, Integer page) {
        // 제목이나 내용에 키워드를 포함하는 게시글을 조회
        Page<AccompanyPost> accompanyPostPage = accompanyPostRepository.findByTitleOrContentContaining(keyword, PageRequest.of(page - 1, 12));
        // Entity를 DTO로 변환하여 반환
        return accompanyPostPage.map(accompanyPostConverter::toAccompanyPostInquiryResponse);
    }
}
