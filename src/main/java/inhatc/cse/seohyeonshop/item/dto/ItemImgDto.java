package inhatc.cse.seohyeonshop.item.dto;

import inhatc.cse.seohyeonshop.item.entity.Item;
import inhatc.cse.seohyeonshop.item.entity.ItemImg;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemImgDto {
    private Long id;
    private Item item;
    private String imgName;
    private String oriImgName;
    private String imgUrl;
    private String repImgYn;

    public static ModelMapper modelMapper= new ModelMapper();
    public static ItemImgDto of(ItemImg itemImg){
        return modelMapper.map(itemImg,ItemImgDto.class);
    }

  /*  public static ItemImg toEntity(ItemImgDto itemImgDto){
        return modelMapper.map(itemImgDto, ItemImg.class);
    }*/

    //위에 거랑 똑같은 기능 (ItemImgDto of) 엔티티를 디티오로 변환
   /* public ItemImgDto entityToDto( ItemImgDto itemImg){
       ItemImgDto itemImgDto=new ItemImgDto();
       itemImgDto.setImgName(itemImg.getImgName());
       itemImgDto.setImgUrl(itemImg.getImgUrl());
       return itemImgDto;
    }*/



}
