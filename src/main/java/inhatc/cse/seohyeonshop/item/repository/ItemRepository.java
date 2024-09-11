package inhatc.cse.seohyeonshop.item.repository;

import inhatc.cse.seohyeonshop.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item>findByItemNm(String itemNm);

    List<Item>findByPriceLessThanOrderByPriceDesc(int price);

    List<Item> findByItemNmLike(String itemNm);

    @Query(value = "select i from Item i where i.itemDetail like %:itemDetail% "+"order by i.price desc")//얘는 item에 entity에 있는걸ㄹ ㅗ접근
    List<Item> findItemDetail(@Param("itemDetail") String itemDetail);

    @Query(value = "select * from item i where i.item_detail like %:itemdetal%"+"order by i.price desc",nativeQuery = true)// item_detial-> 이거는 디비에 있는걸로 접근
    List<Item> findItemDetailNative(@Param("itemDetail") String itemDetail);

}
