package UMC.TravelMate.domain.MannerTemperature.converter;

import UMC.TravelMate.domain.MannerTemperature.entity.MannerTemperature;
import UMC.TravelMate.domain.MannerTemperature.dto.request.MannerTemperatureRequest.MannerTemperatureCreateRequestDTO;
import UMC.TravelMate.domain.MannerTemperature.dto.response.MannerTemperatureResponse.MannerTemperatureCreateResponseDTO;
import UMC.TravelMate.domain.MannerTemperature.dto.response.MannerTemperatureUpdateResponse;
import UMC.TravelMate.domain.MannerTemperature.dto.response.MannerTemperatureInquiryResponse;

public class MannerTemperatureConverter {

    public static MannerTemperature toMannerTemperature(MannerTemperatureCreateRequestDTO dto) {
        return new MannerTemperature(dto.getMemberId(), dto.getTemperature());
    }

    public static MannerTemperatureCreateResponseDTO toMannerTemperatureCreateResponse(MannerTemperature mannerTemperature) {
        return MannerTemperatureCreateResponseDTO.builder()
                .id(mannerTemperature.getId())
                .memberId(mannerTemperature.getMemberId())
                .temperature(mannerTemperature.getTemperature())
                .build();
    }

    public static MannerTemperatureUpdateResponse toMannerTemperatureUpdateResponse(MannerTemperature mannerTemperature) {
        return MannerTemperatureUpdateResponse.builder()
                .id(mannerTemperature.getId())
                .memberId(mannerTemperature.getMemberId())
                .temperature(mannerTemperature.getTemperature())
                .build();
    }

    public static MannerTemperatureInquiryResponse toMannerTemperatureInquiryResponse(MannerTemperature mannerTemperature) {
        return MannerTemperatureInquiryResponse.builder()
                .id(mannerTemperature.getId())
                .memberId(mannerTemperature.getMemberId())
                .temperature(mannerTemperature.getTemperature())
                .build();
    }
}
