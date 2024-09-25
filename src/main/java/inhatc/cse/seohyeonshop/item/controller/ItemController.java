package inhatc.cse.seohyeonshop.item.controller;

import inhatc.cse.seohyeonshop.item.dto.ItemDataDto;
import inhatc.cse.seohyeonshop.item.dto.ItemDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ItemController {
    @GetMapping("/item/thymeleaf1")
    public String thymeleaf1(Model model){
        ItemDto itemDto=ItemDto.builder()
                .id(1L)
                .itemNm("상품명123")
                .itemDetail("상품상세설명123")
                .price(10000)
                .stockNumber(100)
                .build();

        model.addAttribute("item",itemDto);
        return "item/thymeleaf1";   //view단으로 갈때는 기본적으로 루트가 붙어서 /안해줘도 됨.
    }

    @GetMapping("/item/thymeleaf2")
    public String thymeleaf2(ItemDataDto itemDataDto, Model model){
        System.out.println("==================이름"+itemDataDto);
        model.addAttribute("item",itemDataDto);

        return "/item/thymeleaf2";
    }


}
