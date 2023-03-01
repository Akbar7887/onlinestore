package uz.onlinestore.onlinestore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.onlinestore.onlinestore.models.ACTIVE;
import uz.onlinestore.onlinestore.models.catalogs.Catalog;
import uz.onlinestore.onlinestore.models.catalogs.Product;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogDto {

    private Long id;
    private String catalogname;
    private String imagepath;
    private ACTIVE active;
    private List<Catalog> catalogs;
    private Catalog parent;
    private List<Product> products;
}
