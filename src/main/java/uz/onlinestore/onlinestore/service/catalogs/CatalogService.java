package uz.onlinestore.onlinestore.service.catalogs;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.onlinestore.onlinestore.dto.CatalogDto;
import uz.onlinestore.onlinestore.models.ACTIVE;
import uz.onlinestore.onlinestore.models.catalogs.Catalog;
import uz.onlinestore.onlinestore.models.catalogs.Product;
import uz.onlinestore.onlinestore.repository.catalogs.CatalogRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class CatalogService {

    @Autowired
    final CatalogRepository catalogRepository;

    private CatalogDto convertToCatalogDto(Catalog catalog) {

        CatalogDto catalogDto = new CatalogDto();
        catalogDto.setId(catalog.getId());
        catalogDto.setCatalogname(catalog.getCatalogname());
        catalogDto.setImagepath(catalog.getImagepath());
        catalogDto.setActive(catalog.getActive());
        catalogDto.setCatalogs(catalog.getCatalogs());
        catalogDto.setParent(catalog.getParent());
        catalogDto.setProducts(catalog.getProducts());

        return catalogDto;
    }

    public List<CatalogDto> getAllCatalogDto() {
        return catalogRepository.
                getAllActive(ACTIVE.ACTIVE).
                stream().
                map(this::convertToCatalogDto).
                collect(Collectors.toList());
    }

    public List<Catalog> getAllActive() {
        return catalogRepository.getAllActive(ACTIVE.ACTIVE);
    }

    public List<Catalog> getAllActiveAllOfThem() {
        return catalogRepository.getAllActiveAllOfThem(ACTIVE.ACTIVE);
    }

    public Catalog save(Catalog catalog) {
        return catalogRepository.save(catalog);
    }

    public Catalog saveSub(Long id, Catalog catalog) {
        Optional<Catalog> oldCatalog = catalogRepository.findById(id);
        Catalog oldcatalog1;
        if (oldCatalog.isPresent()) {
            oldcatalog1 = oldCatalog.get();
            oldcatalog1.addCatalog(catalog);
            return catalogRepository.save(oldcatalog1);
        }
        return null;
    }

    public Catalog deleteActive(Long id) {
        Optional<Catalog> catalogOptional = catalogRepository.findById(id);
        if (catalogOptional.isPresent()) {
            Catalog catalog = catalogOptional.get();
            catalog.setActive(ACTIVE.NOACTIVE);
            return catalogRepository.save(catalog);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        catalogRepository.deleteById(id);
    }

    public Catalog saveProduct(Long id, Product product) {
        Optional<Catalog> catalogOptional = catalogRepository.findById(id);
        if (catalogOptional.isPresent()) {
            Catalog catalog = catalogOptional.get();
            catalog.addProduct(product);
            return catalogRepository.save(catalog);
        } else {
            return null;
        }
    }
}
