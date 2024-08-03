package UMC.TravelMate.domain.MannerTemperature.controller;

import UMC.TravelMate.domain.MannerTemperature.dto.request.MannerTemperatureRequest.MannerTemperatureCreateRequestDTO;
import UMC.TravelMate.domain.MannerTemperature.dto.request.MannerTemperatureRequest.MannerTemperatureUpdateRequestDTO;
import UMC.TravelMate.domain.MannerTemperature.dto.response.MannerTemperatureResponse.MannerTemperatureCreateResponseDTO;
import UMC.TravelMate.domain.MannerTemperature.dto.response.MannerTemperatureInquiryResponse;
import UMC.TravelMate.domain.MannerTemperature.dto.response.MannerTemperatureUpdateResponse;
import UMC.TravelMate.domain.MannerTemperature.service.MannerTemperatureService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/manner-temperature")
public class MannerTemperatureController {

    @Autowired
    private MannerTemperatureService mannerTemperatureService;

    @PostMapping
    public ResponseEntity<MannerTemperatureCreateResponseDTO> createMannerTemperature(@RequestBody MannerTemperatureCreateRequestDTO request) {
        MannerTemperatureCreateResponseDTO created = mannerTemperatureService.createMannerTemperature(request);
        return ResponseEntity.status(201).body(created);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MannerTemperatureUpdateResponse> updateMannerTemperature(@PathVariable Long id, @RequestBody MannerTemperatureUpdateRequestDTO request) {
        MannerTemperatureUpdateResponse updated = mannerTemperatureService.updateMannerTemperature(id, request);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MannerTemperatureInquiryResponse> inquiryMannerTemperatureById(@PathVariable Long id) {
        MannerTemperatureInquiryResponse response = mannerTemperatureService.inquiryMannerTemperatureById(id);
        return ResponseEntity.ok(response);
    }
}
