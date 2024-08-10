package UMC.TravelMate.domain.MannerTemperature.service;

import UMC.TravelMate.domain.MannerTemperature.dto.request.MannerTemperatureRequest.MannerTemperatureCreateRequestDTO;
import UMC.TravelMate.domain.MannerTemperature.dto.request.MannerTemperatureRequest.MannerTemperatureUpdateRequestDTO;
import UMC.TravelMate.domain.MannerTemperature.dto.response.MannerTemperatureResponse.MannerTemperatureCreateResponseDTO;
import UMC.TravelMate.domain.MannerTemperature.dto.response.MannerTemperatureInquiryResponse;
import UMC.TravelMate.domain.MannerTemperature.dto.response.MannerTemperatureUpdateResponse;

public interface MannerTemperatureService {
    MannerTemperatureCreateResponseDTO createMannerTemperature(MannerTemperatureCreateRequestDTO request);
    MannerTemperatureUpdateResponse updateMannerTemperature(Long mannerTemperatureId, MannerTemperatureUpdateRequestDTO request);
    MannerTemperatureInquiryResponse inquiryMannerTemperatureById(Long mannerTemperatureId);
}