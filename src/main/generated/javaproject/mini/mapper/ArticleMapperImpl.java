package javaproject.mini.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javaproject.mini.dto.article.CreateArticleDto;
import javaproject.mini.dto.article.ReadArticleDto;
import javaproject.mini.dto.article.UpdateArticleDto;
import javaproject.mini.model.article.Article;
import javaproject.mini.model.article.ArticleImage;
import javaproject.mini.model.article.Comment;
import javaproject.mini.model.article.HashTag;
import javaproject.mini.model.member.Member;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-06T23:26:23+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.2 (Eclipse Adoptium)"
)
@Component
public class ArticleMapperImpl implements ArticleMapper {

    @Override
    public Article createArticleDtoToArticle(CreateArticleDto createArticleDto) {
        if ( createArticleDto == null ) {
            return null;
        }

        Article article = new Article();

        article.setContent( createArticleDto.getContent() );
        List<ArticleImage> list = createArticleDto.getImages();
        if ( list != null ) {
            article.setImages( new ArrayList<ArticleImage>( list ) );
        }
        List<HashTag> list1 = createArticleDto.getHashtags();
        if ( list1 != null ) {
            article.setHashtags( new ArrayList<HashTag>( list1 ) );
        }
        article.setSavedAt( createArticleDto.getSavedAt() );

        return article;
    }

    @Override
    public Article updateArticleDtoToArticle(UpdateArticleDto updateArticleDto) {
        if ( updateArticleDto == null ) {
            return null;
        }

        Article article = new Article();

        article.setId( updateArticleDto.getId() );
        article.setContent( updateArticleDto.getContent() );
        List<ArticleImage> list = updateArticleDto.getImages();
        if ( list != null ) {
            article.setImages( new ArrayList<ArticleImage>( list ) );
        }
        List<HashTag> list1 = updateArticleDto.getHashtags();
        if ( list1 != null ) {
            article.setHashtags( new ArrayList<HashTag>( list1 ) );
        }
        article.setSavedAt( updateArticleDto.getSavedAt() );

        return article;
    }

    @Override
    public ReadArticleDto toDto(Article article) {
        if ( article == null ) {
            return null;
        }

        Long id = null;
        Member member = null;
        List<ArticleImage> images = null;
        List<HashTag> hashtags = null;
        String content = null;
        List<Comment> comments = null;
        LocalDateTime savedAt = null;

        id = article.getId();
        member = article.getMember();
        List<ArticleImage> list = article.getImages();
        if ( list != null ) {
            images = new ArrayList<ArticleImage>( list );
        }
        List<HashTag> list1 = article.getHashtags();
        if ( list1 != null ) {
            hashtags = new ArrayList<HashTag>( list1 );
        }
        content = article.getContent();
        List<Comment> list2 = article.getComments();
        if ( list2 != null ) {
            comments = new ArrayList<Comment>( list2 );
        }
        savedAt = article.getSavedAt();

        ReadArticleDto readArticleDto = new ReadArticleDto( id, member, images, hashtags, content, comments, savedAt );

        return readArticleDto;
    }
}
