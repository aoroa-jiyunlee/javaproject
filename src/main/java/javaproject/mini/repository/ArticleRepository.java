package javaproject.mini.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import javaproject.mini.model.article.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ArticleRepository {

    private final EntityManager em;

    public Long create(Article article) {
        em.persist(article);
        return article.getId();
    }

    public Article readOne(Long id) {
        return em.find(Article.class, id);
    }

    public List<Article> readAll() {
        return em.createQuery("select a from Article a", Article.class)
                .getResultList();
    }

    public List<Article> readByMemberId(Long memberId) {
        return em.createQuery("select a from Article a where a.member_id = :memberId", Article.class)
                .setParameter("member_id", memberId)
                .getResultList();
    }

    public Article update(Article article) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Article found = readOne(article.getId());

        found.setImages(article.getImages());
        found.setHashtags(article.getHashtags());
        found.setContent(article.getContent());
        found.setSavedAt(LocalDateTime.now());

        em.merge(found);

        tx.commit();

        return article;
    }

    public Long delete(Long id) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Article found = readOne(id);
        em.remove(found);
        tx.commit();

        return id;
    }
}
