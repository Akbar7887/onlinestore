package uz.onlinestore.onlinestore.repository.calculate;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.onlinestore.onlinestore.models.calculate.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {
}