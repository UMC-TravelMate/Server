package UMC.TravelMate.domain.accompanypost.controller;

import UMC.TravelMate.domain.accompanypost.converter.AccompanyPostConverter;
import UMC.TravelMate.domain.accompanypost.dto.request.AccompanyPostRequest;
import UMC.TravelMate.domain.accompanypost.dto.response.AccompanyPostResponse;
import UMC.TravelMate.domain.accompanypost.entity.AccompanyPost;
import UMC.TravelMate.global.common.BaseResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accompanyposts")
public class AccompanyPostController {

    //private final AccompanyPostService accompanyPostService;

    //@PostMapping("/add")
    /*public BaseResponse<AccompanyPostResponse.AccompanyPostCreateResponseDTO> createAccompanyPost(@RequestBody @Valid AccompanyPostRequest.AccompanyPostCreateRequestDTO requset) {
        AccompanyPost newAccompanyPost = accompanyPostService.createAccompanyPost(requset);
        return BaseResponse.onSuccess(AccompanyPostConverter.toAccompanyPostCreateResponseDTO(newAccompanyPost));
    }*/
}
