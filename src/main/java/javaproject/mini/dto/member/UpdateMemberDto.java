package javaproject.mini.dto.member;

import javaproject.mini.model.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@AllArgsConstructor
public class UpdateMemberDto {
    private Long id;
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
    public UpdateMemberDto translateToDto(Member member) {
        this.setId(member.getId());
        this.setPassword(member.getPassword());
        this.setNickname(member.getNickname());
        this.setName(member.getName());
        this.setMobile(member.getMobile());

        return this;
    }
}
