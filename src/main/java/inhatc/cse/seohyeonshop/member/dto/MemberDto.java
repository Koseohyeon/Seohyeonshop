package inhatc.cse.seohyeonshop.member.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {
    private  String name; //사용자 이름
    private String email; //이메일
    private String password;
    private String address;
}
