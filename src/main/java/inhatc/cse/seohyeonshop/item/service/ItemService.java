package inhatc.cse.seohyeonshop.item.service;

import inhatc.cse.seohyeonshop.item.dto.ItemFormDto;
import inhatc.cse.seohyeonshop.item.entity.Item;
import inhatc.cse.seohyeonshop.item.entity.ItemImg;
import inhatc.cse.seohyeonshop.item.repository.ItemImgRepository;
import inhatc.cse.seohyeonshop.item.repository.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {
    private final ItemImgRepository itemImgRepository;
    private final ItemImageService itemImageService;
    private final ItemRepository itemRepository;

    public Long SaveItem(ItemFormDto itemFormDto, List<MultipartFile> itemImgList) throws IOException {
        Item item=itemFormDto.createItem();
        itemRepository.save(item);

        for (int i = 0; i < itemImgList.size(); i++) {
            ItemImg itemImg=new ItemImg();
            itemImg.setItem(item);
            if(i==0){
                itemImg.setRepImgYn("Y");
            }else {
                itemImg.setRepImgYn("N");
            }
            itemImageService.saveItemImg(itemImg,itemImgList.get(i));
        }
        return item.getId();
    }

}
