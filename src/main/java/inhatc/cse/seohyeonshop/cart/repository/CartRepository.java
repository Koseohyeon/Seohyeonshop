package inhatc.cse.seohyeonshop.cart.repository;

import inhatc.cse.seohyeonshop.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {

}
