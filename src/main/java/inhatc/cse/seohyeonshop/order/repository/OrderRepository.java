package inhatc.cse.seohyeonshop.order.repository;

import inhatc.cse.seohyeonshop.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
