package uz.onlinestore.onlinestore.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import uz.onlinestore.onlinestore.models.ACTIVE;
import uz.onlinestore.onlinestore.models.catalogs.Catalog;
import uz.onlinestore.onlinestore.models.catalogs.Characteristic;
import uz.onlinestore.onlinestore.models.catalogs.ProductImage;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {


    private Long id;
    private String name;
    private String description;
    private String imagepath;
    private ACTIVE active = ACTIVE.ACTIVE;
//    private Catalog catalog;
    private List<ProductImage> productImages ;
  //  private List<Characteristic> characteristics ;

}
