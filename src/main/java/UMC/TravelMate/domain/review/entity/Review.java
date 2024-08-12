package UMC.TravelMate.domain.review.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Member;
import java.util.List;

@Setter
@Getter
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToOne
    //@JoinColumn(name = "member_id", nullable = false)
    //private Member member;

    //@ManyToOne
    //@JoinColumn(name = "post_id", nullable = false)
    //private Post post;

    @ManyToOne
    @JoinColumn(name = "parent_review_id")
    private Review parentReview;

    @OneToMany(mappedBy = "parentReview", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> childReviews;

    @Column(nullable = false)
    private String content;

    // Getters and Setters

}