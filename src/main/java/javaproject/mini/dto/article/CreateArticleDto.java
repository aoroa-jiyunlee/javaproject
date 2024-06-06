package javaproject.mini.dto.article;

import jakarta.persistence.*;
import javaproject.mini.model.article.*;
import javaproject.mini.model.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateArticleDto {
    private Member member;
    private List<ArticleImage> images;
    private List<HashTag> hashtags;
    private String content;
    private LocalDateTime savedAt;

    public Article translateToModel() {
        Article article = new Article();
        article.setMember(member);
        article.setImages(images);
        article.setHashtags(hashtags);
        article.setContent(content);
        article.setSavedAt(LocalDateTime.now());

        return article;
    }
}
