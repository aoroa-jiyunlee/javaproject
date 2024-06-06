package javaproject.mini.dto.article;

import jakarta.validation.constraints.NotBlank;
import javaproject.mini.model.article.*;
import javaproject.mini.model.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateArticleDto {
    private Long memberId;
    private Long member_id;

    @NotBlank
    private String content;

    private List<ArticleImage> images;
    private List<HashTag> hashtags;
    private LocalDateTime savedAt;
}
