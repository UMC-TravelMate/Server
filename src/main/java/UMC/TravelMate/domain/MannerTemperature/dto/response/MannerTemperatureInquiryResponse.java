package UMC.TravelMate.domain.MannerTemperature.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MannerTemperatureInquiryResponse {
    private Long id;               // 매너 온도의 ID
    private Long memberId;         // 회원 ID
    private Double temperature;    // 매너 온도
}
