package inhatc.cse.seohyeonshop.order.entity;

import inhatc.cse.seohyeonshop.common.entity.BaseEntity;
import inhatc.cse.seohyeonshop.member.entity.Member;
import inhatc.cse.seohyeonshop.order.constant.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    //Long 대문자 쓰는 이유는 레파지토리에서 Long 형을 써줘야 해서
    private  Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime orderDate;    //주문일
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "order",
        cascade = CascadeType.ALL, orphanRemoval = true)

    //12주차 과제(영속성 테스트)
    //@OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems =new ArrayList();
}
