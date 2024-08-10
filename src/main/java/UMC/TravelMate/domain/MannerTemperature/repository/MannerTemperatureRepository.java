package UMC.TravelMate.domain.MannerTemperature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import UMC.TravelMate.domain.MannerTemperature.entity.MannerTemperature;

@Repository
public interface MannerTemperatureRepository extends JpaRepository<MannerTemperature, Long> {
    MannerTemperature findByMemberId(Long memberId);
}
