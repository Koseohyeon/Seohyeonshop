package inhatc.cse.seohyeonshop.cart.entity;

import inhatc.cse.seohyeonshop.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;

import java.lang.management.LockInfo;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    //Long 대문자 쓰는 이유는 레파지토리에서 Long 형을 써줘야 해서
    private  Long id;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

}
