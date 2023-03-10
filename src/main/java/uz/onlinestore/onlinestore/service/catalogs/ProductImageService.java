package uz.onlinestore.onlinestore.service.catalogs;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.onlinestore.onlinestore.fileupload.FileService;
import uz.onlinestore.onlinestore.models.catalogs.ProductImage;
import uz.onlinestore.onlinestore.repository.catalogs.ProductImageRepository;

import java.io.File;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ProductImageService {

    @Autowired
    final ProductImageRepository productImageRepository;
    private final FileService fileService;

    public List<ProductImage> getByParentId(Long id) {
        return productImageRepository.getByParentId(id);
    }

    public ProductImage getById(Long id) {
        return productImageRepository.getById(id);
    }

    public void delete(Long id) {
        ProductImage productImage = productImageRepository.getById(id);
        if (fileService.delete("products-" + productImage.getImagepath())){
            productImageRepository.deleteById(id);
        };
    }

    public ProductImage save(ProductImage productImage) {
        return productImageRepository.save(productImage);
    }

}
