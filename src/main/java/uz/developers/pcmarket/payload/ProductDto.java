package uz.developers.pcmarket.payload;

import lombok.Data;
import uz.developers.pcmarket.entity.Attachment;
import uz.developers.pcmarket.entity.Category;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
public class ProductDto {


    private String name;

    private Integer categoryId;

    private Integer photoId;

    private String code;

    private double price;
}
