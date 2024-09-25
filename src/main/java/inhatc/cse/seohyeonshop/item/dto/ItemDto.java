package inhatc.cse.seohyeonshop.item.dto;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDto {
    private Long id;    //아이디
    private String itemNm;  //상품명
    private int price;  //가격
    private int stockNumber;    //재고수량
    private String itemDetail;  //상품 상세 설명
}
