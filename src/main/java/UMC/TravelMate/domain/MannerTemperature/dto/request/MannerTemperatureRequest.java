package UMC.TravelMate.domain.MannerTemperature.dto.request;

import lombok.Getter;

public class MannerTemperatureRequest {

    @Getter
    public static class MannerTemperatureCreateRequestDTO {
        private Long memberId;
        private Double temperature;

    }

    @Getter
    public static class MannerTemperatureUpdateRequestDTO {
        private Double temperature;
    }
}
