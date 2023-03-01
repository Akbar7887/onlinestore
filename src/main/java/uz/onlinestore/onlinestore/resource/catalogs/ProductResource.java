package uz.onlinestore.onlinestore.resource.catalogs;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.onlinestore.onlinestore.dto.ProductDto;
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
    private List<ProductDto> getAll() {
        return productService.getAllProductDto();
    }

    @GetMapping("getbyid")
    private Product getById(@RequestParam("id") String id) {
        return productService.getById(Long.parseLong(id));
    }


    @DeleteMapping("delete")
    private void delete(@RequestParam("id") Long id) throws Exception {
        productService.delete(id);
    }

    @PostMapping("addcharacter")
    private Product saveCharacter(@RequestParam("id") String id, @RequestBody Characteristic characteristic) {
        return characteristicService.saveCharacteristic(Long.parseLong(id), characteristic);
    }

    @PostMapping("removecharacter")
    private Product saveCharacter(@RequestParam("id") String id) {
        return characteristicService.removeCharacteristic(Long.parseLong(id));
    }
}
