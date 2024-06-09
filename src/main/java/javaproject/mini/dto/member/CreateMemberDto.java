package javaproject.mini.dto.member;

import javaproject.mini.model.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class CreateMemberDto {
    private String email;
    private String password;
    private String nickname;
    private String name;
    private Long mobile;
    private int birthYear;

    public Member translateToModel() {
        Member member = new Member();
        member.setEmail(email);
        member.setPassword(password);
        member.setNickname(nickname);
        member.setName(name);
        member.setMobile(mobile);
        member.setBirthYear(birthYear);

        return member;
    }
}
