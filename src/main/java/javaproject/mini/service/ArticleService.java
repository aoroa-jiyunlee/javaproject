package javaproject.mini.service;

import javaproject.mini.model.article.Article;
import javaproject.mini.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional
    public Article create(Article article) {
        articleRepository.create(article);
        return article;
    }

    public List<Article> findArticles() {
        return articleRepository.readAll();
    }

    public Article findOneArticle(Long articleId) {
        return articleRepository.readOne(articleId);
    }

    @Transactional
    public Article update(Article article) {
        return articleRepository.update(article);
    }

    @Transactional
    public Long delete(Long articleId) {
        return articleRepository.delete(articleId);
    }
}
