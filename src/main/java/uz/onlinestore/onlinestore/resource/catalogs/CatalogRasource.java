package uz.onlinestore.onlinestore.resource.catalogs;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.onlinestore.onlinestore.models.catalogs.Catalog;
import uz.onlinestore.onlinestore.models.catalogs.Product;
import uz.onlinestore.onlinestore.service.catalogs.CatalogService;

import java.util.List;

@RestController
@RequestMapping("/online/doc/catalog/")
@RequiredArgsConstructor
public class CatalogRasource {

    @Autowired
    private final CatalogService catalogService;

    @GetMapping("get")
    private List<Catalog> getAll() {
        return catalogService.getAllActive();
    }

    @GetMapping("getall")
    private List<Catalog> getAllActiveAllOfThem() {
        return catalogService.getAllActiveAllOfThem();
    }

    @PostMapping("save")
    private Catalog save(@RequestBody Catalog catalog) {
        return catalogService.save(catalog);
    }

    @PostMapping("savesub")
    private Catalog savesub(@RequestParam("id") String id, @RequestBody Catalog catalog) {
        return catalogService.saveSub(Long.parseLong(id), catalog);
    }

    @PutMapping("deleteactive")
    private Catalog deleteActive(@RequestParam("id") String id){
        return catalogService.deleteActive(Long.parseLong(id));
    }

    @DeleteMapping("delete/{id}")
    private void delete(@PathVariable Long id) throws Exception {
        catalogService.delete(id);
    }
    // =======
    @PostMapping("saveproduct")
    private Catalog saveProduct(@RequestParam("id") String id, @RequestBody Product product){
        return catalogService.saveProduct(Long.parseLong(id), product);
    }


}
