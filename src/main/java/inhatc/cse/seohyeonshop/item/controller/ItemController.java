package inhatc.cse.seohyeonshop.item.controller;

import inhatc.cse.seohyeonshop.item.dto.ItemDataDto;
import inhatc.cse.seohyeonshop.item.dto.ItemDto;
import inhatc.cse.seohyeonshop.item.dto.ItemFormDto;
import inhatc.cse.seohyeonshop.item.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.BindParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    @PostMapping("/admin/item/add")
    public String itemAdd(@Valid ItemFormDto itemFormDto,//form에서 넘어온 데이터
                          BindingResult bindingResult,//바인딩 결과
                          @RequestParam("itemImgFile") List<MultipartFile>itemImgList,
                          Model model){
        if(bindingResult.hasErrors()){
            return "member/add";
        }
        if(itemImgList.get(0).isEmpty()&&itemFormDto.getId()==null){
            model.addAttribute("errorMessage","첫번째 상품의 이미지는 필수입니다");
            return "item/add";
        }
        try {
            itemService.SaveItem(itemFormDto,itemImgList);
        } catch (IOException e) {
            model.addAttribute("errorMessage","파일 저장에 실패했습니다.다시!!");
            return "item/add";
        }
        return "redirect:/";
    }


        @GetMapping("/admin/item/add")
    public String itemForm(Model model){
        model.addAttribute("itemFormDto",new ItemFormDto());
        return "item/add";
    }

    @GetMapping("/admin/items")
    public String itemList(){
        return "item/list";
    }

    @GetMapping("/item/thymeleaf1")     // root(/)부터 시작
    public String thymeleaf1(Model model){
        ItemDto itemDto=ItemDto.builder()
                .id(1L)
                .itemNm("상품명")
                .itemDetail("상품상세설명")
                .price(10000)
                .stockNumber(100)
                .build();
        model.addAttribute("item", itemDto);
        return "item/thymeleaf1";   //  view 단으로 갈때는 기본적으로 루트가 붙어서 /안해줘도 됨.
    }

    @GetMapping("/item/thymeleaf2")     // root(/)부터 시작
    public String thymeleaf2(ItemDataDto itemDataDto, Model model) {
        System.out.println("===================" + itemDataDto);

        model.addAttribute("item", itemDataDto);

        return "item/thymeleaf2";
    }

    @GetMapping("/item/eachEX")
    public String eachEX(Model model){
        List<ItemDto> itemDtoList = new ArrayList<>();

        for(int i=1; i<=5; i++){
            ItemDto itemDto = new ItemDto();
            itemDto.setId(1L * i);
            itemDto.setItemNm("상품명" + i);
            itemDto.setItemDetail("상품 상세 설명" + i);
            itemDto.setPrice(10000 * i);
            itemDto.setStockNumber(100 * i);

            itemDtoList.add(itemDto);
        }

        model.addAttribute("itemDtoList", itemDtoList);
        return "item/eachEX";
    }

    @GetMapping("/item/ifEX")
    public String ifEX(Model model){
        List<ItemDto> itemDtoList = new ArrayList<>();

        for(int i=1; i<=5; i++){
            ItemDto itemDto = new ItemDto();
            itemDto.setId(1L * i);
            itemDto.setItemNm("상품명" + i);
            itemDto.setItemDetail("상품 상세 설명" + i);
            itemDto.setPrice(10000 * i);
            itemDto.setStockNumber(100 * i);

            itemDtoList.add(itemDto);
        }

        model.addAttribute("itemDtoList", itemDtoList);
        return "item/ifEX";
    }

    @GetMapping("/item/switchEX")
    public String switchEX(Model model){
        List<ItemDto> itemDtoList = new ArrayList<>();

        for(int i=1; i<=5; i++){
            ItemDto itemDto = new ItemDto();
            itemDto.setId(1L * i);
            itemDto.setItemNm("상품명" + i);
            itemDto.setItemDetail("상품 상세 설명" + i);
            itemDto.setPrice(10000 * i);
            itemDto.setStockNumber(100 * i);

            itemDtoList.add(itemDto);
        }

        model.addAttribute("itemDtoList", itemDtoList);
        return "item/switchEX";
    }
}
