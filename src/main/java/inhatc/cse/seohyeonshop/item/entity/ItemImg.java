package inhatc.cse.seohyeonshop.item.entity;

import inhatc.cse.seohyeonshop.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemImg extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    @Column(name = "item_img_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private String imgName;
    private String oriImgName;
    private String imgUrl;
    private String repImgYn;

    public void updateItemImg(String oriImgName,String imgName,String imgUrl){
        this.oriImgName=oriImgName;
        this.imgName=imgName;
        this.imgUrl=imgUrl;
    }





}
