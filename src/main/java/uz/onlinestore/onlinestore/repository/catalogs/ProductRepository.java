package uz.onlinestore.onlinestore.repository.catalogs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.onlinestore.onlinestore.models.ACTIVE;
import uz.onlinestore.onlinestore.models.catalogs.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select c from Product c where c.active = :active and c.catalog.id = :catalog_id")
    List<Product> getAllActive(@Param("active") ACTIVE active, @Param("catalog_id") Long id);
}