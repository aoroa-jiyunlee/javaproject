package javaproject.mini.mapper;

import javaproject.mini.dto.member.CreateMemberDto;
import javaproject.mini.dto.member.UpdateMemberDto;
import javaproject.mini.model.member.Member;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-06T23:44:05+0900",
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
}
