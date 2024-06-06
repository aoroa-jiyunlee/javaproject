package javaproject.mini.repository;

import jakarta.persistence.*;
import jakarta.validation.ValidationException;
import javaproject.mini.model.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    @PersistenceContext
    private final EntityManager em;

    public Long create(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member readOne(Long id) {
        Member member = em.find(Member.class, id);

        if (member == null) {
            throw new ValidationException("존재하지 않는 회원입니다.");
        }
        if (!member.getActivate()) {
            throw new ValidationException("탈퇴한 회원입니다.");
        }

        return member;
    }

    public List<Member> readAll() {
        return em.createQuery("select m from Member m where m.activate = true", Member.class)
                .getResultList();
    }

    public List<Member> readByNickName(String nickname) {
        return em.createQuery("select m from Member m where m.nickname = :nickname and m.activate = true", Member.class)
                .setParameter("nickname", nickname)
                .getResultList();
    }

    @Transactional
    public Member update(Long id, Member member) {
        Member found = readOne(id);

        if (member.getNickname() != null) {
            found.setNickname(member.getNickname());
        }
        if (member.getMobile() != null){
            found.setName(member.getName());
        }
        if (member.getPassword() != null) {
            found.setPassword(member.getPassword());
        }
        if (member.getName() != null) {
            found.setName(member.getName());
        }

        return member;
    }

    @Transactional
    public Long delete(Long id) {
        Member found = readOne(id);

        found.setActivate(false);

        return id;
    }
}
