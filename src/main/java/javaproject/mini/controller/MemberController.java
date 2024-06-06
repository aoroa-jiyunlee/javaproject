package javaproject.mini.controller;

import jakarta.validation.Valid;
import javaproject.mini.dto.member.CreateMemberDto;
import javaproject.mini.dto.member.ReadMemberDto;
import javaproject.mini.dto.member.UpdateMemberDto;
import javaproject.mini.mapper.MemberMapper;
import javaproject.mini.model.member.Member;
import javaproject.mini.response.ApiResponse;
import javaproject.mini.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(originPatterns = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberMapper memberMapper;

    @PostMapping
    public ResponseEntity<ApiResponse> createMember(@RequestBody @Valid CreateMemberDto memberDto) {
        Member member = memberService.join(memberMapper.createMemberDtoToMember(memberDto));

        ApiResponse apiResponse = new ApiResponse(member.getId(), "Created");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateMember(@PathVariable("id") Long id, @RequestBody @Valid UpdateMemberDto memberDto) {
        Member member = memberService.update(id, memberMapper.updateMemberDtoToMember(memberDto));

        ApiResponse apiResponse = new ApiResponse(member.getId(), "Updated");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> findMembers() {
        List<Member> members = memberService.findMembers();
        List<ReadMemberDto> memberDtos = members.stream()
                .map(m -> new ReadMemberDto(
                        m.getId(), m.getEmail(), m.getNickname(), m.getName(), m.getMobile(), m.getBirthYear(),
                        m.getArticles(), m.getComments()
                )).collect(Collectors.toList());

        ApiResponse apiResponse = new ApiResponse(memberDtos, "Success");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findOneMember(@PathVariable("id") Long id) {
        Member m = memberService.findOneMember(id);
        ReadMemberDto memberDto = new ReadMemberDto(
                m.getId(), m.getEmail(), m.getNickname(), m.getName(), m.getMobile(), m.getBirthYear(),
                m.getArticles(), m.getComments()
        );

        ApiResponse apiResponse = new ApiResponse(memberDto, "Success");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteMember(@PathVariable("id") Long id) {
        memberService.delete(id);

        ApiResponse apiResponse = new ApiResponse(id, "Deleted");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
