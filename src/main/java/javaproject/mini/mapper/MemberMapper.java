package javaproject.mini.mapper;

import javaproject.mini.dto.member.CreateMemberDto;
import javaproject.mini.dto.member.ReadMemberDto;
import javaproject.mini.dto.member.UpdateMemberDto;
import javaproject.mini.model.member.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    @Mapping(target = "activate", constant = "true")
    Member createMemberDtoToMember(CreateMemberDto createMemberDto);

    Member updateMemberDtoToMember(UpdateMemberDto updateMemberDto);
}
