package UMC.TravelMate.domain.review.repository;

import UMC.TravelMate.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    // 특정 memberId로 리뷰를 조회하는 메서드
    List<Review> findByMemberId(Long memberId);

    // 특정 postId로 리뷰를 조회하는 메서드
    List<Review> findByPostId(Long postId);

//    @Query("SELECT r FROM Review r WHERE r.member.id = :memberId AND r.post.id = :postId")
//    List<Review> findByMemberIdAndPostId(@Param("memberId") Long memberId, @Param("postId") Long postId);
}
