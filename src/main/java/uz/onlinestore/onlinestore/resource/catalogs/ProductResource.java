package uz.onlinestore.onlinestore.resource.catalogs;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @Autowired
    private final CharacteristicService characteristicService;

    @GetMapping("get")
    private List<Product> getAll() {
        return productService.getAllActive();
    }

//    @PostMapping("save")
//    private Product save(@RequestBody Product product) {
//        return productService.save(product);
//    }

    @DeleteMapping("delete")
    private void delete(@RequestParam("id") Long id) throws Exception {
        productService.delete(id);
    }

    @PostMapping("addcharacter")
    private Product saveCharacter(@RequestParam("id") String id, @RequestBody  Characteristic characteristic){
        return characteristicService.saveCharacteristic(Long.parseLong(id), characteristic);
    }

    @PostMapping("removecharacter")
    private Product saveCharacter(@RequestParam("id") String id){
        return characteristicService.removeCharacteristic(Long.parseLong(id));
    }
}
