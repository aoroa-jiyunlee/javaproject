package javaproject.mini.dto.article;

import jakarta.validation.constraints.NotBlank;
import javaproject.mini.model.article.ArticleImage;
import javaproject.mini.model.article.HashTag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateArticleDto {
    @NotBlank
    private Long id;

    private List<ArticleImage> images;
    private List<HashTag> hashtags;
    private String content;
    private LocalDateTime savedAt;
}
