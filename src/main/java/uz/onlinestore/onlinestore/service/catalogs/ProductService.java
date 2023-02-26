package uz.onlinestore.onlinestore.service.catalogs;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.onlinestore.onlinestore.models.ACTIVE;
import uz.onlinestore.onlinestore.models.catalogs.Product;
import uz.onlinestore.onlinestore.repository.catalogs.ProductRepository;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ProductService {

    @Autowired
    final ProductRepository productRepository;

    public List<Product> getAllActive() {
        return productRepository.getAllActive(ACTIVE.ACTIVE);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }


}
