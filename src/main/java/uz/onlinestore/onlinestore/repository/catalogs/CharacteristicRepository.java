package uz.onlinestore.onlinestore.repository.catalogs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.onlinestore.onlinestore.models.catalogs.Characteristic;

import java.util.List;

public interface CharacteristicRepository extends JpaRepository<Characteristic, Long> {

    @Query("select c from Characteristic c where c.product.id= :id")
    List<Characteristic> getByProductId(@Param("id") Long id);
}