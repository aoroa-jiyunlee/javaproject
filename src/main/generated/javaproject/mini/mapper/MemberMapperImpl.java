package javaproject.mini.mapper;

import java.util.ArrayList;
import java.util.List;
import javaproject.mini.dto.member.CreateMemberDto;
import javaproject.mini.dto.member.ReadMemberDto;
import javaproject.mini.dto.member.UpdateMemberDto;
import javaproject.mini.model.article.Article;
import javaproject.mini.model.article.Comment;
import javaproject.mini.model.member.Member;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-06T23:24:20+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.2 (Eclipse Adoptium)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member createMemberDtoToMember(CreateMemberDto createMemberDto) {
        if ( createMemberDto == null ) {
            return null;
        }

        Member member = new Member();

        member.setEmail( createMemberDto.getEmail() );
        member.setPassword( createMemberDto.getPassword() );
        member.setNickname( createMemberDto.getNickname() );
        member.setName( createMemberDto.getName() );
        member.setMobile( createMemberDto.getMobile() );
        member.setBirthYear( createMemberDto.getBirthYear() );

        member.setActivate( true );

        return member;
    }

    @Override
    public Member updateMemberDtoToMember(UpdateMemberDto updateMemberDto) {
        if ( updateMemberDto == null ) {
            return null;
        }

        Member member = new Member();

        member.setPassword( updateMemberDto.getPassword() );
        member.setNickname( updateMemberDto.getNickname() );
        member.setName( updateMemberDto.getName() );
        member.setMobile( updateMemberDto.getMobile() );

        return member;
    }

    @Override
    public ReadMemberDto toDto(Member member) {
        if ( member == null ) {
            return null;
        }

        Long id = null;
        String email = null;
        String nickname = null;
        String name = null;
        Long mobile = null;
        int birthYear = 0;
        List<Article> articles = null;
        List<Comment> comments = null;

        id = member.getId();
        email = member.getEmail();
        nickname = member.getNickname();
        name = member.getName();
        mobile = member.getMobile();
        birthYear = member.getBirthYear();
        List<Article> list = member.getArticles();
        if ( list != null ) {
            articles = new ArrayList<Article>( list );
        }
        List<Comment> list1 = member.getComments();
        if ( list1 != null ) {
            comments = new ArrayList<Comment>( list1 );
        }

        ReadMemberDto readMemberDto = new ReadMemberDto( id, email, nickname, name, mobile, birthYear, articles, comments );

        return readMemberDto;
    }
}
