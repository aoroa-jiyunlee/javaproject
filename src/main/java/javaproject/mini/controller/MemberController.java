package javaproject.mini.controller;

import jakarta.validation.Valid;
import javaproject.mini.dto.member.CreateMemberDto;
import javaproject.mini.dto.member.ReadMemberDto;
import javaproject.mini.dto.member.UpdateMemberDto;
import javaproject.mini.model.member.Member;
import javaproject.mini.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/v1/member")
    public CreateMemberResponse createMember(@RequestBody @Valid CreateMemberDto request) {
        Member member = memberService.join(request.translateToModel());
        return new CreateMemberResponse(member.getId());
    }

    @PutMapping("/api/v1/member")
    public UpdateMemberResponse updateMember(@RequestBody @Valid UpdateMemberDto request) {
        Member member = memberService.update(request.translateToModel());
        return new UpdateMemberResponse(member.getId());
    }

    @GetMapping("/api/v1/member")
    public FindMemberResponse findMembers() {
        List<Member> members = memberService.findMembers();
        List<ReadMemberDto> memberDtos = members.stream()
                .map(m -> new ReadMemberDto(
                        m.getId(), m.getEmail(), m.getNickname(), m.getName(), m.getMobile(), m.getBirthYear(),
                        m.getArticles(), m.getComments()
                )).collect(Collectors.toList());

        return new FindMemberResponse(memberDtos);
    }

    @GetMapping("/api/v1/member/{id}")
    public GetMemberResponse findOneMember(@PathVariable("id") Long id) {
        Member m = memberService.findOneMember(id);
        ReadMemberDto memberDto = new ReadMemberDto(
                m.getId(), m.getEmail(), m.getNickname(), m.getName(), m.getMobile(), m.getBirthYear(),
                m.getArticles(), m.getComments()
        );
        return new GetMemberResponse(memberDto);
    }

    @Data
    static class CreateMemberResponse {
        private Long id;

        public CreateMemberResponse(Long id) {
            this.id = id;
        }
    }

    @Data
    static class UpdateMemberResponse {
        private Long id;
        public UpdateMemberResponse(Long id) {
            this.id = id;
        }
    }

    @Data
    @AllArgsConstructor
    static class FindMemberResponse {
        private List<ReadMemberDto> members;
    }

    @Data
    @AllArgsConstructor
    static class GetMemberResponse {
        private ReadMemberDto member;
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }
}
