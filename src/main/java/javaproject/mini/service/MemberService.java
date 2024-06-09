package javaproject.mini.service;

import javaproject.mini.model.member.Member;
import javaproject.mini.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member join(Member member) {
        validateDuplicatedMember(member);
        memberRepository.create(member);
        return member;
    }

    private void validateDuplicatedMember(Member member) {
        List<Member> findMembers = memberRepository.readByNickName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<Member> findMembers() {
        return memberRepository.readAll();
    }

    public Member findOneMember(Long memberId) {
        return memberRepository.readOne(memberId);
    }

    @Transactional
    public Member update(Member member) {
        return memberRepository.update(member);
    }

    @Transactional
    public Long delete(Long memberId) {
        return memberRepository.delete(memberId);
    }
}
