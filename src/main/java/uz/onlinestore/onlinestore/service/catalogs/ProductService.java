package uz.onlinestore.onlinestore.service.catalogs;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import uz.onlinestore.onlinestore.dto.ProductDto;
import uz.onlinestore.onlinestore.models.ACTIVE;
import uz.onlinestore.onlinestore.models.catalogs.Catalog;
import uz.onlinestore.onlinestore.models.catalogs.Characteristic;
import uz.onlinestore.onlinestore.models.catalogs.Product;
import uz.onlinestore.onlinestore.models.catalogs.ProductImage;
import uz.onlinestore.onlinestore.repository.catalogs.CharacteristicRepository;
import uz.onlinestore.onlinestore.repository.catalogs.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class ProductService {

    @Autowired
    final ProductRepository productRepository;
    @Autowired
    final CharacteristicRepository characteristicRepository;

    public  List<ProductDto> getAllProductDto(){
       return productRepository
                .getAllActive(ACTIVE.ACTIVE)
                .stream()
                .map(this::convertToProductDto)
                .collect(Collectors.toList());
    }

    private  ProductDto convertToProductDto(Product product){
        ProductDto productDto = new ProductDto();

        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setImagepath(product.getImagepath());
//        productDto.setCatalog(product.getCatalog());
        productDto.setProductImages(product.getProductImages());
        return  productDto;
    }
    public List<Product> getAllActive() {
        return productRepository.getAllActive(ACTIVE.ACTIVE);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public Product getById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElse(null);
    }




}
