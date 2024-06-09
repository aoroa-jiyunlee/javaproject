package javaproject.mini.dto.member;

import lombok.*;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMemberDto {
    private String password;
    private String nickname;
    private String name;
    private Long mobile;
}
