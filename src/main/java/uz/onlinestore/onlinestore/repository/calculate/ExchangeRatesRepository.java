package uz.onlinestore.onlinestore.repository.calculate;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.onlinestore.onlinestore.models.calculate.ExchangeRates;

public interface ExchangeRatesRepository extends JpaRepository<ExchangeRates, Long> {

}