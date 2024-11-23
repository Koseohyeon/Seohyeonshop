package inhatc.cse.seohyeonshop.item.repository;

import inhatc.cse.seohyeonshop.item.constant.ItemSellStatus;
import inhatc.cse.seohyeonshop.item.entity.Item;
import inhatc.cse.seohyeonshop.member.constant.Role;
import inhatc.cse.seohyeonshop.member.entity.Member;
import inhatc.cse.seohyeonshop.member.repository.MemberRepository;
import inhatc.cse.seohyeonshop.order.entity.Order;
import inhatc.cse.seohyeonshop.order.entity.OrderItem;
import inhatc.cse.seohyeonshop.order.repository.OrderItemRepository;
import inhatc.cse.seohyeonshop.order.repository.OrderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.antlr.v4.runtime.atn.SemanticContext;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@Transactional
public class OrderTest {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    OrderItemRepository orderItemRepository;

    @PersistenceContext
    EntityManager em;

    public Item createItem(){
        Item item= new Item();
        item.setItemNm("테스트 상품");
        item.setPrice(10000);
        item.setItemDetail("상세설명");
        item.setItemSellStatus(ItemSellStatus.SELL);
        item.setStockNumber(100);
        item.setRegTime(LocalDateTime.now());
        item.setUpdateTime(LocalDateTime.now());
        return item;
    }

    @Test
    @DisplayName("영속성 테스트")
    public void cascadeTest(){
        Order order=new Order();
        for (int i = 0; i < 3; i++) {
            Item item=this.createItem();
            itemRepository.save(item);
            OrderItem orderItem=new OrderItem();
            orderItem.setItem(item);
            orderItem.setCount(10);
            orderItem.setOrderPrice(1000);
            orderItem.setOrder(order);
            order.getOrderItems().add(orderItem);

        }
        orderRepository.saveAndFlush(order);
        em.clear();

        Order savedOrder=orderRepository.findById(order.getId())
                .orElseThrow(EntityNotFoundException::new);
        assertEquals(3, savedOrder.getOrderItems().size());

    }

    public Order createOrder() {
        Order order = new Order();
        for (int i = 0; i < 3; i++) {
            Item item = createItem();
            itemRepository.save(item);

            OrderItem orderItem = new OrderItem();
            orderItem.setItem(item);
            orderItem.setCount(10);
            orderItem.setOrderPrice(1000);
            orderItem.setOrder(order);

            // OrderItem을 Order에 추가
            order.getOrderItems().add(orderItem);
        }

        // Member 객체 생성 시 필수 필드를 설정
        Member member = new Member();
        member.setEmail("example@example.com"); // 적절한 email 값 설정
        member.setName("test"); // 적절한 name 설정
        member.setPassword("test"); // 적절한 password 설정
        member.setRole(Role.USER); // 적절한 role 설정

        memberRepository.save(member);

        order.setMember(member);
        orderRepository.save(order);

        return order;
    }
    @Test
    @DisplayName("고아객체테스트")
    public  void orphanRemovalTest(){
        Order order= this.createOrder();
        order.getOrderItems().remove(0);
        em.flush();
    }

    @Test
    @DisplayName("지연 로딩 테스트 ")
    public void lazyLoadingTest(){
        Order order=this.createOrder();
        Long orderItemId= order.getOrderItems().get(0).getId();
        em.flush();
        em.clear();

        OrderItem orderItem= orderItemRepository.findById(orderItemId)
                .orElseThrow(EntityNotFoundException::new);
        System.out.println("Order class : "+ orderItem.getOrder().getClass());
        System.out.println("==========================");
        orderItem.getOrder().getOrderDate();
        System.out.println("==========================");
    }


}
