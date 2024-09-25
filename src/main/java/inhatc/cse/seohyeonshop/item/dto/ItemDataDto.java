package inhatc.cse.seohyeonshop.item.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDataDto {
    private String name;
    private int age;
    private String dept;
    private int grade;
}
