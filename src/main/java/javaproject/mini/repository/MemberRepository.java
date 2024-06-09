package javaproject.mini.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import javaproject.mini.model.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public Long create(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member readOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> readAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> readByNickName(String nickname) {
        return em.createQuery("select m from Member m where m.nickname = :nickname", Member.class)
                .setParameter("nickname", nickname)
                .getResultList();
    }

    public Member update(Member member) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member found = readOne(member.getId());

        found.setNickname(member.getNickname());
        found.setName(member.getName());
        found.setMobile(member.getMobile());

        em.merge(found);

        tx.commit();

        return member;
    }

    public Long delete(Long id) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member found = readOne(id);
        em.remove(found);
        tx.commit();

        return id;
    }
}
