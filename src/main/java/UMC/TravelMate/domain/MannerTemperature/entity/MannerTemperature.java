package UMC.TravelMate.domain.MannerTemperature.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "manner_temperature")
public class MannerTemperature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "temperature", nullable = false)
    private Double temperature;

    // Constructors, getters, setters
    public MannerTemperature() {}

    public MannerTemperature(Long memberId, Double temperature) {
        this.memberId = memberId;
        this.temperature = temperature;
    }

}
