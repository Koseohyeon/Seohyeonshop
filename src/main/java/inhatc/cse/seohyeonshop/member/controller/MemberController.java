package inhatc.cse.seohyeonshop.member.controller;

import inhatc.cse.seohyeonshop.member.dto.MemberDto;
import inhatc.cse.seohyeonshop.member.entity.Member;
import inhatc.cse.seohyeonshop.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    @GetMapping("/add")
    public String memberAdd(Model model){
        model.addAttribute("memberDto",new MemberDto());

        return "member/add";
    }

    @PostMapping("/add")
    public String memberNew(MemberDto memberDto){
        Member member = Member.createMember(memberDto, passwordEncoder);
        memberService.saveMember(member);

        return "redirect:/";
    }





}
