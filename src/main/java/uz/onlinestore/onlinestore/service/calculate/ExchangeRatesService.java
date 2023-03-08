package uz.onlinestore.onlinestore.service.calculate;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import uz.onlinestore.onlinestore.models.calculate.ExchangeRates;
import uz.onlinestore.onlinestore.repository.calculate.ExchangeRatesRepository;

import java.rmi.server.ExportException;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ExchangeRatesService {

    @Autowired
    final private ExchangeRatesRepository exchangeRatesRepository;

    public List<ExchangeRates> getAll(){
        return  exchangeRatesRepository.findAll();
    }

    public List<ExchangeRates> getbyDate(Date date){
        return exchangeRatesRepository.getByDate(date);
    }

    public ExchangeRates save(ExchangeRates exchangeRates){
        return exchangeRatesRepository.save(exchangeRates);
    }

    public void delete(Long id){
        exchangeRatesRepository.deleteById(id);
    }

}
