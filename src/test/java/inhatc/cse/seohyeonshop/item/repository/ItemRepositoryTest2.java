package inhatc.cse.seohyeonshop.item.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import inhatc.cse.seohyeonshop.item.constant.ItemSellStatus;
import inhatc.cse.seohyeonshop.item.entity.Item;
import inhatc.cse.seohyeonshop.item.entity.QItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import java.util.List;

import static inhatc.cse.seohyeonshop.item.entity.QItem.item;

@SpringBootTest
class ItemRepositoryTest2 {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private EntityManager em;
    public void createItemList(){
        for (int i = 1; i <= 10; i++) {
            Item item= Item.builder()
                    .itemNm("신상품"+i)
                    .itemSellStatus(ItemSellStatus.SELL)
                    .itemDetail("신상품 상세 설명"+i)
                    .price(10000+i)
                    .stockNumber(100)
                    .build();

            itemRepository.save(item);
            
        }
    }
    public void createItemList2(){
        for (int i = 1; i <= 5; i++) {
            Item item= Item.builder()
                    .itemNm("신상품"+i)
                    .itemDetail("신상품 상세 설명"+i)
                    .itemSellStatus(ItemSellStatus.SELL)
                    .price(10000+i)
                    .stockNumber(100)
                    .build();

            itemRepository.save(item);

        }
        for (int i = 6; i <= 10; i++) {
            Item item= Item.builder()
                    .itemNm("신상품"+i)
                    .itemDetail("신상품 상세 설명"+i)
                    .itemSellStatus(ItemSellStatus.SOLD_OUT)
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
    @Test
    @DisplayName("querydsl테스트")
    public  void querydslTest(){
        createItemList();
        JPAQueryFactory query= new JPAQueryFactory(em);

        List<Item> itemList = query.selectFrom(item)
                .where(item.itemSellStatus.eq(ItemSellStatus.SELL))
                .where(item.itemDetail.like("%"+"1"+"%"))
                .orderBy(item.price.desc())
                .fetch();

        itemList.forEach((item -> System.out.println(item)));

    }
    @Test
    @DisplayName("querydsl2테스트")
    public  void querydslTest2(){
        createItemList2();
        BooleanBuilder builder=new BooleanBuilder();
        String itemDetail="신상품";
        int price=10002;
        String itemSellStatus="SELL";
        QItem item=QItem.item;

        builder.and(item.itemDetail.like("%"+itemDetail+"%"));
        builder.and(item.price.gt(price));
        if(StringUtils.equals(itemSellStatus,ItemSellStatus.SELL)){
            builder.and(item.itemSellStatus.eq(ItemSellStatus.SELL));
        }

        Pageable pageable= PageRequest.of(0,5);
        Page<Item> page = itemRepository.findAll(builder, pageable);
        List<Item> content = page.getContent();
        content.stream().forEach((e)->{
            System.out.println(e);
        });

        //itemRepository.findAll()



    }



    
}