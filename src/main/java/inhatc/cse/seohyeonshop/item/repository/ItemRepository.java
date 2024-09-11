package inhatc.cse.seohyeonshop.item.repository;

import inhatc.cse.seohyeonshop.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item>findByItemNm(String itemNm);

}
