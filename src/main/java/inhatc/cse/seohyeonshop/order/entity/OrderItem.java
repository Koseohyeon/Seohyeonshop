package inhatc.cse.seohyeonshop.order.entity;

import inhatc.cse.seohyeonshop.common.entity.BaseEntity;
import inhatc.cse.seohyeonshop.item.entity.Item;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    //Long 대문자 쓰는 이유는 레파지토리에서 Long 형을 써줘야 해서
    private  Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private int orderPrice;
    private int count;
}
