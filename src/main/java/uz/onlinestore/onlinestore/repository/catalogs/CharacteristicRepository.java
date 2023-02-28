package uz.onlinestore.onlinestore.repository.catalogs;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.onlinestore.onlinestore.models.catalogs.Characteristic;

public interface CharacteristicRepository extends JpaRepository<Characteristic, Long> {
}