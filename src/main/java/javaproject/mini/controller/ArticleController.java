package javaproject.mini.controller;

import jakarta.validation.Valid;
import javaproject.mini.dto.article.CreateArticleDto;
import javaproject.mini.dto.article.ReadArticleDto;
import javaproject.mini.dto.article.UpdateArticleDto;
import javaproject.mini.model.article.Article;
import javaproject.mini.service.ArticleService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/api/v1/article")
    public CreateArticleResponse createArticle(@RequestBody @Valid CreateArticleDto request) {
        Article article = articleService.create(request.translateToModel());
        return new CreateArticleResponse(article.getId());
    }

    @PutMapping("/api/v1/article")
    public UpdatearticleResponse updatearticle(@RequestBody @Valid UpdateArticleDto request) {
        Article article = articleService.update(request.translateToModel());
        return new UpdatearticleResponse(article.getId());
    }

    @GetMapping("/api/v1/article")
    public FindarticleResponse findarticles() {
        List<Article> articles = articleService.findArticles();
        List<ReadArticleDto> articleDtos = articles.stream()
                .map(a -> new ReadArticleDto(
                        a.getId(), a.getMember(), a.getImages(), a.getHashtags(),
                        a.getContent(), a.getComments(), a.getSavedAt()
                )).collect(Collectors.toList());

        return new FindarticleResponse(articleDtos);
    }

    @GetMapping("/api/v1/article/{id}")
    public GetArticleResponse findOnearticle(@PathVariable("id") Long id) {
        Article a = articleService.findOneArticle(id);
        ReadArticleDto articleDto = new ReadArticleDto(
                a.getId(), a.getMember(), a.getImages(), a.getHashtags(),
                a.getContent(), a.getComments(), a.getSavedAt()
        );
        return new GetArticleResponse(articleDto);
    }

    @Data
    static class CreateArticleResponse {
        private Long id;

        public CreateArticleResponse(Long id) {
            this.id = id;
        }
    }

    @Data
    static class UpdatearticleResponse {
        private Long id;
        public UpdatearticleResponse(Long id) {
            this.id = id;
        }
    }

    @Data
    @AllArgsConstructor
    static class FindarticleResponse {
        private List<ReadArticleDto> articles;
    }

    @Data
    @AllArgsConstructor
    static class GetArticleResponse {
        private ReadArticleDto article;
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }
}
