package javaproject.mini.mapper;

import javaproject.mini.dto.article.CreateArticleDto;
import javaproject.mini.dto.article.ReadArticleDto;
import javaproject.mini.dto.article.UpdateArticleDto;
import javaproject.mini.model.article.Article;
import javaproject.mini.model.member.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    Article createArticleDtoToArticle(CreateArticleDto createArticleDto);

    Article updateArticleDtoToArticle(UpdateArticleDto updateArticleDto);

    ReadArticleDto toDto(Article article);
}
