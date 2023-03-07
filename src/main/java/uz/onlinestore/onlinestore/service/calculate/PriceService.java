package uz.onlinestore.onlinestore.service.calculate;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.onlinestore.onlinestore.models.calculate.ExchangeRates;
import uz.onlinestore.onlinestore.models.calculate.Price;
import uz.onlinestore.onlinestore.repository.calculate.PriceRepository;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public List<Price> getAll(){
        return  priceRepository.findAll();
    }

    public Price save(Price price){
        return priceRepository.save(price);
    }

    public void delete(Long id){
        priceRepository.deleteById(id);
    }
}
