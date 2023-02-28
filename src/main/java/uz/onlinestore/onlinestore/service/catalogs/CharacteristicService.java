package uz.onlinestore.onlinestore.service.catalogs;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.onlinestore.onlinestore.models.catalogs.Characteristic;
import uz.onlinestore.onlinestore.models.catalogs.Product;
import uz.onlinestore.onlinestore.repository.catalogs.CharacteristicRepository;
import uz.onlinestore.onlinestore.repository.catalogs.ProductRepository;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CharacteristicService {

    @Autowired
    final CharacteristicRepository characteristicRepository;
    @Autowired
    final ProductRepository productRepository;
    // == == == Characteristic
    public Product saveCharacteristic(Long id, Characteristic characteristic) {


        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.addCharacteristic(characteristic);
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
