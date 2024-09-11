package inhatc.cse.seohyeonshop.item.repository;

import inhatc.cse.seohyeonshop.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {


}
