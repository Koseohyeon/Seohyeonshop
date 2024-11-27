package inhatc.cse.seohyeonshop.item.service;

import inhatc.cse.seohyeonshop.item.entity.ItemImg;
import inhatc.cse.seohyeonshop.item.repository.ItemImgRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemImageService {
    private  final ItemImgRepository itemImgRepository;
    private final FileService fileService;

    @Value(value = "${itemImgLocation}")
    private String itemImgLocation;

    public void saveItemImg(ItemImg itemImg, MultipartFile itemImgFile) throws IOException {
        String oriImgName=itemImgFile.getOriginalFilename();
        String imgName="";
        String imgUrl="";
        if(!StringUtils.isEmpty(oriImgName)){
            imgName=fileService.uploadFile(itemImgLocation,oriImgName,itemImgFile.getBytes());
            imgUrl="/images/item/"+imgName;
        }
        itemImg.updateItemImg(oriImgName,imgName,imgUrl);
        itemImgRepository.save(itemImg);


    }


}
