package uz.onlinestore.onlinestore.repository.catalogs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.onlinestore.onlinestore.models.ACTIVE;
import uz.onlinestore.onlinestore.models.catalogs.Catalog;

import java.util.List;

public interface CatalogRepository extends JpaRepository<Catalog, Long> {

    @Query("select c from Catalog c where c.active = :active and c.parent.id is not null")
    List<Catalog> getAllActive(@Param("active") ACTIVE active);

    @Query("select c from Catalog c where c.active = :active")
    List<Catalog> getAllActiveAllOfThem(@Param("active") ACTIVE active);
}