package javaproject.mini.service;

import jakarta.validation.ValidationException;
import javaproject.mini.model.member.Member;
import javaproject.mini.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member join(Member member) {
        validateDuplicatedMember(member);
        memberRepository.create(member);
        return member;
    }

    private void validateDuplicatedMember(Member member) {
        List<Member> findMembers = memberRepository.readByNickName(member.getNickname());
        if (!findMembers.isEmpty()) {
            throw new ValidationException("이미 존재하는 회원입니다.");
        }
    }

    public List<Member> findMembers() {
        return memberRepository.readAll();
    }

    public Member findOneMember(Long memberId) {
        return memberRepository.readOne(memberId);
    }

    public Member update(Long id, Member member) {
        return memberRepository.update(id, member);
    }

    public Long delete(Long memberId) {
        return memberRepository.delete(memberId);
    }
}
