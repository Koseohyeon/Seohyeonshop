package inhatc.cse.seohyeonshop.member.repository;

import inhatc.cse.seohyeonshop.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    //이메일이 있을수도 있고 없을수도 있기 떄문에 Optional로 해줌
    Optional<Member> findByEmail(String email);
}
