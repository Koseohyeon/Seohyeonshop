package inhatc.cse.seohyeonshop.member.service;

import inhatc.cse.seohyeonshop.member.entity.Member;
import inhatc.cse.seohyeonshop.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member saveMember(Member member){
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member) {

        Optional<Member> mem = memberRepository.findByEmail(member.getEmail());
        if (mem.isPresent()){
            Member m=mem.get();
            throw new IllegalStateException("이미 가입된 회원입니다");
        }

    }

}
