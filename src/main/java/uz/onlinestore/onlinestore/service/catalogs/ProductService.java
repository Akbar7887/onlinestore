package uz.onlinestore.onlinestore.service.catalogs;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.onlinestore.onlinestore.models.ACTIVE;
import uz.onlinestore.onlinestore.models.catalogs.Characteristic;
import uz.onlinestore.onlinestore.models.catalogs.Product;
import uz.onlinestore.onlinestore.repository.catalogs.CharacteristicRepository;
import uz.onlinestore.onlinestore.repository.catalogs.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ProductService {

    @Autowired
    final ProductRepository productRepository;
    @Autowired
    final CharacteristicRepository characteristicRepository;

    public List<Product> getAllActive() {
        return productRepository.getAllActive(ACTIVE.ACTIVE);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    // == == == Characteristic
    public Product saveCharacteristic(Long id, Characteristic characteristic) {

        Characteristic characteristic1 = characteristicRepository.save(characteristic);

            Optional<Product> productOptional = productRepository.findById(id);
            if (productOptional.isPresent()) {
                Product product = productOptional.get();
                product.addCharacteristic(characteristic1);
                return productRepository.save(product);
            } else {
                return null;
            }


    }
    public Product removeCharacteristic(Long id) {

        Optional<Characteristic> characteristicOptional = characteristicRepository.findById(id);
        if (characteristicOptional.isPresent()) {
            Characteristic characteristic = characteristicOptional.get();
            Product product = characteristic.getProduct();
            product.removeCharacteristic(characteristic);
            return productRepository.save(product);
        } else {
            return null;
        }

    }


}
