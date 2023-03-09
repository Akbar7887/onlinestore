package uz.onlinestore.onlinestore.service.catalogs;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.onlinestore.onlinestore.dto.ProductDto;
import uz.onlinestore.onlinestore.models.ACTIVE;
import uz.onlinestore.onlinestore.models.catalogs.Product;
import uz.onlinestore.onlinestore.models.catalogs.ProductImage;
import uz.onlinestore.onlinestore.repository.catalogs.CatalogRepository;
import uz.onlinestore.onlinestore.repository.catalogs.CharacteristicRepository;
import uz.onlinestore.onlinestore.repository.catalogs.ProductImageRepository;
import uz.onlinestore.onlinestore.repository.catalogs.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ProductImageService {

    @Autowired
    final ProductImageRepository productImageRepository;



    public ProductImage getById(Long id) {
        return productImageRepository.getById(id);
    }

    public void delete(Long id) {
         productImageRepository.deleteById(id);
    }

    public ProductImage save(ProductImage productImage) {
        return productImageRepository.save(productImage);
    }

}
