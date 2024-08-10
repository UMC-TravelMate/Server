package UMC.TravelMate.domain.MannerTemperature.dto.response;


import lombok.Builder;
import lombok.Getter;

public class MannerTemperatureResponse {

    @Builder
    @Getter
    public static class MannerTemperatureCreateResponseDTO {
        private Long id;
        private Long memberId;
        private Double temperature;
    }
}