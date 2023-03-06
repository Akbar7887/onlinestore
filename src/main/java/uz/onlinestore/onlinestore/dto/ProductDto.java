package uz.onlinestore.onlinestore.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.onlinestore.onlinestore.models.ACTIVE;
import uz.onlinestore.onlinestore.models.catalogs.Catalog;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {


    private Long id;
    private String name;
    private String description;
    private String imagepath;
    private ACTIVE active = ACTIVE.ACTIVE;
    private Catalog catalog;
//    private List<ProductImage> productImages ;
//    private List<Characteristic> characteristics ;

}
