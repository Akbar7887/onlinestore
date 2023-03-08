package uz.onlinestore.onlinestore.repository.calculate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.onlinestore.onlinestore.models.calculate.ExchangeRates;

import java.util.Date;
import java.util.List;

public interface ExchangeRatesRepository extends JpaRepository<ExchangeRates, Long> {

    @Query("select e from ExchangeRates e  where e.date <= :date ")
    List<ExchangeRates> getByDate(@Param("date") Date date);
}