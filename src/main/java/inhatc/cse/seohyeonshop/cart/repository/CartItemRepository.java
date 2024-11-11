package inhatc.cse.seohyeonshop.cart.repository;

import inhatc.cse.seohyeonshop.cart.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {

}
