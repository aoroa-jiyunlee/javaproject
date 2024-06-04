package javaproject.mini.model.article;

import jakarta.persistence.*;
import javaproject.mini.model.member.Member;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ArticleLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;
}
