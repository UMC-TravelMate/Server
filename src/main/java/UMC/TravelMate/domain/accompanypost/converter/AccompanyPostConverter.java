package UMC.TravelMate.domain.accompanypost.converter;

import UMC.TravelMate.domain.accompanypost.dto.request.AccompanyPostRequest;
import UMC.TravelMate.domain.accompanypost.dto.response.AccompanyPostInquiryResponse;
import UMC.TravelMate.domain.accompanypost.dto.response.AccompanyPostResponse;
import UMC.TravelMate.domain.accompanypost.dto.response.AccompanyPostUpdateResponse;
import UMC.TravelMate.domain.accompanypost.entity.AccompanyPost;
import UMC.TravelMate.domain.accompanypost.enums.AccompanionType;
import UMC.TravelMate.domain.accompanypost.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Member;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@Component
public class AccompanyPostConverter {
    //동행게시글 생성
    public static AccompanyPostResponse.AccompanyPostCreateResponseDTO toAccompanyPostCreateResponseDTO(AccompanyPost accompanyPost) {

        return AccompanyPostResponse.AccompanyPostCreateResponseDTO.builder()
                .accompanyPostId(accompanyPost.getId())
                .createdAt(LocalDate.now()) //t
                .build();
    }
    
    public static AccompanyPost toAccompanyPost(AccompanyPostRequest.AccompanyPostCreateRequestDTO request/* Member member*/){ //request로 받은 dto로 게시글 생성
        
        log.info("Content received in request: {}", request.getContent());
        return AccompanyPost.builder()
                .title(request.getTitle())
                .destination(request.getDestination())
                .content(request.getContent())
                .startAt(request.getStartAt())
                .endAt(request.getEndAt())
                .language(request.getLanguage())
                .minAge(request.getMinAge())
                .maxAge(request.getMaxAge())
                .gender(request.getGender())
                .accompanionType(request.getAccompanionType())
                .minParticipants(request.getMinParticipants())
                .maxParticipants(request.getMaxParticipants())
                .build();


    }

    //동행게시글 삭제
    public static AccompanyPostResponse.AccompanyPostDeleteResponseDTO toAccompanyPostDeleteResponseDTO(Long deletedAccompanyPostId) {

        return AccompanyPostResponse.AccompanyPostDeleteResponseDTO.builder()
                .accompanyPostId(deletedAccompanyPostId)
                .deletedAt(LocalDate.now())
                .build();
    }



    //동행게시글 조회
    public AccompanyPostInquiryResponse toAccompanyPostInquiryResponse(AccompanyPost accompanyPost) {

        return AccompanyPostInquiryResponse.builder()
                .accompanyPostId(accompanyPost.getId())
                .title(accompanyPost.getTitle())
                .content(accompanyPost.getContent())
                .destination(accompanyPost.getDestination())
                .startAt(accompanyPost.getStartAt())
                .endAt(accompanyPost.getEndAt())
                .language(accompanyPost.getLanguage())
                .minAge(accompanyPost.getMinAge())
                .maxAge(accompanyPost.getMaxAge())
                .gender(accompanyPost.getGender())
                .accompanionType(accompanyPost.getAccompanionType())
                .maxParticipants(accompanyPost.getMaxParticipants())
                .minParticipants(accompanyPost.getMinParticipants())
                .currentParticipants(accompanyPost.getCurrentParticipants())
                .isConfirmed(accompanyPost.getIsConfirmed())
                //.createdAt(accompanyPost.getCreatedAt())
                .build();


    }

    //동행게시글 수정
    public AccompanyPostUpdateResponse toAccompanyPostUpdateResponse(AccompanyPost accompanyPost) {

        return AccompanyPostUpdateResponse.builder()
                .accompanyPostId(accompanyPost.getId())
                .title(accompanyPost.getTitle())
                .content(accompanyPost.getContent())
                .destination(accompanyPost.getDestination())
                .startAt(accompanyPost.getStartAt())
                .endAt(accompanyPost.getEndAt())
                .language(accompanyPost.getLanguage())
                .minAge(accompanyPost.getMinAge())
                .maxAge(accompanyPost.getMaxAge())
                .gender(accompanyPost.getGender())
                .accompanionType(accompanyPost.getAccompanionType())
                .minParticipants(accompanyPost.getMinParticipants())
                .maxParticipants(accompanyPost.getMaxParticipants())
                .currentParticipants(accompanyPost.getCurrentParticipants())
                .isConfirmed(accompanyPost.getIsConfirmed())
                //.modifiedAt(accompanyPost.getModifiedAt())
                .build();
    }


}
