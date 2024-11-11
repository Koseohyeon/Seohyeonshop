package inhatc.cse.seohyeonshop.member.service;

import inhatc.cse.seohyeonshop.member.dto.MemberDto;
import inhatc.cse.seohyeonshop.member.entity.Member;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional  // DB에 넣어서 테스트를 진행, 테스트 끝나면 DB 내용을 지움
class MemberServiceTest {

    @Autowired  // 자동으로 객체 생성
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MemberService memberService;

    private Member createMember() {
        MemberDto memberDto = MemberDto.builder()
                .name("홍길동")
                .email("hong@email.com")
                .address("인천 미추홀구")
                .password("1111")
                .build();
        Member member = Member.createMember(memberDto, passwordEncoder);

        return member;
    }

    @Test
    @DisplayName("사용자 등록 테스트")
    void saveMember() {
        Member member = createMember();
        Member savedMember = memberService.saveMember(member);
        assertEquals("hong@email.com",savedMember.getEmail()); //앞에 기댓값 뒤에 실제 값
    }
}