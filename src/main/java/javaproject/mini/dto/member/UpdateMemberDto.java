package javaproject.mini.dto.member;

import javaproject.mini.model.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMemberDto {
    private String password;
    private String nickname;
    private String name;
    private Long mobile;

    public Member translateToModel() {
        Member member = new Member();
        member.setPassword(password);
        member.setNickname(nickname);
        member.setName(name);
        member.setMobile(mobile);

        return member;
    }
}
