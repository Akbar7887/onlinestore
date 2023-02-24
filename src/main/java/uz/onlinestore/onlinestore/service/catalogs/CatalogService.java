package uz.onlinestore.onlinestore.service.catalogs;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.onlinestore.onlinestore.models.ACTIVE;
import uz.onlinestore.onlinestore.models.catalogs.Catalog;
import uz.onlinestore.onlinestore.repository.catalogs.CatalogRepository;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CatalogService {

    final CatalogRepository catalogRepository;

    public List<Catalog> getAllActive(){
        return catalogRepository.getAllActive(ACTIVE.ACTIVE);
    }

    public Catalog save(Catalog warehouse) {
        return catalogRepository.save(warehouse);
    }

    public void delete(Long id) {
        catalogRepository.deleteById(id);
    }
}
