package uz.onlinestore.onlinestore.resource.catalogs;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.onlinestore.onlinestore.dto.ProductDto;
import uz.onlinestore.onlinestore.models.catalogs.Catalog;
import uz.onlinestore.onlinestore.models.catalogs.Characteristic;
import uz.onlinestore.onlinestore.models.catalogs.Product;
import uz.onlinestore.onlinestore.service.catalogs.CharacteristicService;
import uz.onlinestore.onlinestore.service.catalogs.ProductService;

import java.util.List;

@RestController
@RequestMapping("/online/doc/product/")
@RequiredArgsConstructor
public class ProductResource {

    @Autowired
    private final ProductService productService;

    @GetMapping("get")
    private List<ProductDto> getAll(@RequestParam("id") String catalog_id) {
        return productService.getAllProductDto(Long.parseLong(catalog_id));
    }

    @GetMapping("getbyid")
    private Product getById(@RequestParam("id") String id) {
        return productService.getById(Long.parseLong(id));
    }


    @PutMapping("delete")
    private Product delete(@RequestParam("id") Long id) throws Exception {
       return  productService.delete(id);
    }

    @PostMapping("save")
    private ProductDto saveProduct(@RequestBody Product product){
        return productService.save(product);
    }


}
