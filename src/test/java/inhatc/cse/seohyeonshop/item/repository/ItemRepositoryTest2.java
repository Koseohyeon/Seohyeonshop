package inhatc.cse.seohyeonshop.item.repository;

import inhatc.cse.seohyeonshop.item.constant.ItemSellStatus;
import inhatc.cse.seohyeonshop.item.entity.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class ItemRepositoryTest2 {

    @Autowired
    private ItemRepository itemRepository;
    public void createItemList(){
        for (int i = 1; i <= 10; i++) {
            Item item= Item.builder()
                    .itemNm("신상품"+i)
                    .itemDetail("신상품 상세 설명"+i)
                    .price(10000+i)
                    .stockNumber(100)
                    .build();

            itemRepository.save(item);
            
        }
    }

    @Test
    public void test(){
        System.out.println("AAAAAAAAAAAAAA");
    }
    @Test
    @DisplayName("상품등록테스트")
    public void insertItemTest(){
        Item item= Item.builder()
                .itemNm("신상품2")
                .itemDetail("신상품 상세 설명2")
                .price(10000)
                .stockNumber(100)
                .build();

        itemRepository.save(item);
        Item savedItem=itemRepository.save(item);
        System.out.println(savedItem);

    }

    @Test
    public void findByItemNmTest(){
        List<Item> itemList=itemRepository.findByItemNm("신상품2");
        for (Item item : itemList) {
            System.out.println(item);
            
        }

        itemList.forEach(item -> System.out.println(item));

    }

    @Test
    @DisplayName("OR테스트")
    public void findByItemNmOrItemDetailTest(){
        List<Item> itemlist = itemRepository.findByItemNmOrItemDetail("신상품2", "신상품 상세 설명2");
        itemlist.forEach(item -> {
            System.out.println(item);
        });

    }

    @Test
    @DisplayName("OrderBy테스트")
    public  void findByPriceLessThanOrderByPriceDescTest(){
        itemRepository.findByPriceLessThanOrderByPriceDesc(1005)
                .forEach(System.out::println);

    }

    
}