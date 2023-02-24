package uz.onlinestore.onlinestore.repository.catalogs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.onlinestore.onlinestore.models.ACTIVE;
import uz.onlinestore.onlinestore.models.catalogs.Catalog;

import java.util.List;

public interface CatalogRepository extends JpaRepository<Catalog, Long> {

    @Query("select c from Catalog c where c.active = :active")
    List<Catalog> getAllActive(@Param("active") ACTIVE active);
}