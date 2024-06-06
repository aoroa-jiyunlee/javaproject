package javaproject.mini.controller;

import jakarta.validation.Valid;
import javaproject.mini.dto.article.CreateArticleDto;
import javaproject.mini.dto.article.ReadArticleDto;
import javaproject.mini.dto.article.UpdateArticleDto;
import javaproject.mini.mapper.ArticleMapper;
import javaproject.mini.model.article.Article;
import javaproject.mini.response.ApiResponse;
import javaproject.mini.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(originPatterns = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    private final ArticleMapper articleMapper;

    @PostMapping
    public ResponseEntity<ApiResponse> createArticle(@RequestBody @Valid CreateArticleDto articleDto) {
        Article article = articleService.create(articleMapper.createArticleDtoToArticle(articleDto));

        ApiResponse apiResponse = new ApiResponse(article.getId(), "Created");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ApiResponse> updateArticle(@RequestBody @Valid UpdateArticleDto articleDto) {
        Article article = articleService.update(articleMapper.updateArticleDtoToArticle(articleDto));

        ApiResponse apiResponse = new ApiResponse(article.getId(), "Updated");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> findArticles() {
        List<Article> articles = articleService.findArticles();
        List<ReadArticleDto> articleDtos = articles.stream()
                .map(articleMapper::toDto).collect(Collectors.toList());

        ApiResponse apiResponse = new ApiResponse(articleDtos, "Updated");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findOneArticle(@PathVariable("id") Long id) {
        Article a = articleService.findOneArticle(id);
        ReadArticleDto articleDto = articleMapper.toDto(a);

        ApiResponse apiResponse = new ApiResponse(articleDto, "Updated");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
