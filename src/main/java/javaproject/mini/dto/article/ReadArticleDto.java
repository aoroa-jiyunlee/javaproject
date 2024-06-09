package javaproject.mini.dto.article;

import javaproject.mini.model.article.Article;
import javaproject.mini.model.article.ArticleImage;
import javaproject.mini.model.article.Comment;
import javaproject.mini.model.article.HashTag;
import javaproject.mini.model.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ReadArticleDto {
    private Long id;
    private Member member;
    private List<ArticleImage> images;
    private List<HashTag> hashtags;
    private String content;
    private List<Comment> comments;
    private LocalDateTime savedAt;


    public Article translateToModel() {
        Article article = new Article();
        article.setId(id);
        article.setImages(images);
        article.setHashtags(hashtags);
        article.setContent(content);
        article.setSavedAt(LocalDateTime.now());

        return article;
    }
}
