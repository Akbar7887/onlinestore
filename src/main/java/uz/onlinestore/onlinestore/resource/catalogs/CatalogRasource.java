package uz.onlinestore.onlinestore.resource.catalogs;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.onlinestore.onlinestore.models.catalogs.Catalog;
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

    @PostMapping("save")
    private ResponseEntity<Catalog> save(@RequestBody Catalog catalog) {
        return ResponseEntity.ok().body(catalogService.save(catalog));
    }

    @DeleteMapping("delete/{id}")
    private void delete(@PathVariable Long id) throws Exception {

        catalogService.delete(id);
    }

}
