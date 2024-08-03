package UMC.TravelMate.domain.MannerTemperature.service;

import UMC.TravelMate.domain.MannerTemperature.entity.MannerTemperature;
import UMC.TravelMate.domain.MannerTemperature.repository.MannerTemperatureRepository;
import UMC.TravelMate.domain.MannerTemperature.dto.request.MannerTemperatureRequest.MannerTemperatureCreateRequestDTO;
import UMC.TravelMate.domain.MannerTemperature.dto.request.MannerTemperatureRequest.MannerTemperatureUpdateRequestDTO;
import UMC.TravelMate.domain.MannerTemperature.dto.response.MannerTemperatureResponse.MannerTemperatureCreateResponseDTO;
import UMC.TravelMate.domain.MannerTemperature.dto.response.MannerTemperatureInquiryResponse;
import UMC.TravelMate.domain.MannerTemperature.dto.response.MannerTemperatureUpdateResponse;
import UMC.TravelMate.domain.MannerTemperature.service.MannerTemperatureService;
import UMC.TravelMate.domain.MannerTemperature.converter.MannerTemperatureConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MannerTemperatureServiceImpl implements MannerTemperatureService {

    private final MannerTemperatureRepository mannerTemperatureRepository;
    private final MannerTemperatureConverter mannerTemperatureConverter;

    private static final double DEFAULT_TEMPERATURE = 10.0;

    @Override
    @Transactional
    public MannerTemperatureCreateResponseDTO createMannerTemperature(MannerTemperatureCreateRequestDTO request) {
        MannerTemperature newMannerTemperature = mannerTemperatureConverter.toMannerTemperature(request);
        newMannerTemperature.setTemperature(DEFAULT_TEMPERATURE); // 기본값 설정
        MannerTemperature savedMannerTemperature = mannerTemperatureRepository.save(newMannerTemperature);
        return mannerTemperatureConverter.toMannerTemperatureCreateResponse(savedMannerTemperature);
    }

    @Override
    @Transactional
    public MannerTemperatureUpdateResponse updateMannerTemperature(Long mannerTemperatureId, MannerTemperatureUpdateRequestDTO request) {
        MannerTemperature mannerTemperature = mannerTemperatureRepository.findById(mannerTemperatureId)
                .orElseThrow(() -> new RuntimeException("Manner temperature not found"));
        mannerTemperature.setTemperature(request.getTemperature());
        MannerTemperature updatedMannerTemperature = mannerTemperatureRepository.save(mannerTemperature);
        return mannerTemperatureConverter.toMannerTemperatureUpdateResponse(updatedMannerTemperature);
    }

    @Override
    @Transactional(readOnly = true)
    public MannerTemperatureInquiryResponse inquiryMannerTemperatureById(Long mannerTemperatureId) {
        MannerTemperature mannerTemperature = mannerTemperatureRepository.findById(mannerTemperatureId)
                .orElseThrow(() -> new RuntimeException("Manner temperature not found"));
        return mannerTemperatureConverter.toMannerTemperatureInquiryResponse(mannerTemperature);
    }
}
