package javaproject.mini.dto.member;

import javaproject.mini.model.article.Article;
import javaproject.mini.model.article.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ReadMemberDto {
    private Long id;
    private String email;
    private String nickname;
    private String name;
    private Long mobile;
    private int birthYear;
    private List<Article> articles;
    private List<Comment> comments;
}
