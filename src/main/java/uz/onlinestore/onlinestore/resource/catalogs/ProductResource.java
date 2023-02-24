package uz.onlinestore.onlinestore.resource.catalogs;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.onlinestore.onlinestore.models.catalogs.Product;
import uz.onlinestore.onlinestore.service.catalogs.ProductService;

import java.util.List;

@RestController
@RequestMapping("/online/doc/product/")
@RequiredArgsConstructor
public class ProductResource {

    @Autowired
    private final ProductService productService;

    @GetMapping("get")
    private List<Product> getAll() {
        return productService.getAllActive();
    }

    @PostMapping("save")
    private Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("delete/{id}")
    private void delete(@PathVariable Long id) throws Exception {
        productService.delete(id);
    }

}
