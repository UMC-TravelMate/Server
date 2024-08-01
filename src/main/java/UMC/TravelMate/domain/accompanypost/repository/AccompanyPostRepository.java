package UMC.TravelMate.domain.accompanypost.repository;

import UMC.TravelMate.domain.accompanypost.entity.AccompanyPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;


public interface AccompanyPostRepository extends JpaRepository<AccompanyPost, Long> {

    Page<AccompanyPost> findAll(Pageable pageable);

    // 여행 여정 조회 - 시간, 위치
    @Query("SELECT a FROM AccompanyPost a WHERE a.startAt >= :startDate AND a.endAt <= :endDate AND (:destination IS NULL OR a.destination = :destination)")
    Page<AccompanyPost> findByTravelPeriodAndOptionalDestination(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("destination") String destination,
            Pageable pageable
    );

    //게시글 최신순 조회
    @Query("SELECT a FROM AccompanyPost a ORDER BY a.createdAt DESC")
    Page<AccompanyPost> findAllOrderByCreatedAtDesc(Pageable pageable);

    // 조건에 맞는 게시글 조회 -?
    @Query("SELECT a FROM AccompanyPost a WHERE a.title LIKE %:keyword% OR a.content LIKE %:keyword%")
    Page<AccompanyPost> findByTitleOrContentContaining(String keyword, Pageable pageable);

    // 특정 조건에 맞는 게시글 조회
    @Query("SELECT a FROM AccompanyPost a WHERE a.minParticipants <= :participants AND a.maxParticipants >= :participants")
    Page<AccompanyPost> findByParticipantRange(Integer participants, Pageable pageable);
}
