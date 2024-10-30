package inhatc.cse.seohyeonshop.member.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {
    @NotBlank(message = "이름은 필수 항목입니다")
    private  String name; //사용자 이름
    @NotBlank(message = "이메일은 필수 항목입니다")
    @Email(message = "이메일형식으로 입력하세요.")
    private String email; //이메일
    @NotBlank(message = "비밀번호는 필수 항목입니다")
    @Length(min = 3,max = 16, message = "비밀번호는 3글자 이상 16글자 이하입니다")
    private String password;
    @NotBlank(message = "주소는 필수 항목입니다")
    private String address;
}
