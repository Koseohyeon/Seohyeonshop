package inhatc.cse.seohyeonshop.order.repository;

import inhatc.cse.seohyeonshop.order.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository  extends JpaRepository<OrderItem,Long> {

}
