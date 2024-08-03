package UMC.TravelMate.domain.MannerTemperature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByPostId(Long postId);
}
