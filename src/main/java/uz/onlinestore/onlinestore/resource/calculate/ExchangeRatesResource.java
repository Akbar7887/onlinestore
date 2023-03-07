package uz.onlinestore.onlinestore.resource.calculate;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.onlinestore.onlinestore.models.calculate.ExchangeRates;
import uz.onlinestore.onlinestore.service.calculate.ExchangeRatesService;

import java.util.List;

@RestController
@RequestMapping("/online/doc/exchange/")
@RequiredArgsConstructor
public class ExchangeRatesResource {

    @Autowired
    final private ExchangeRatesService exchangeRatesService;

    @GetMapping("get")
    private List<ExchangeRates> getAll() {
        return exchangeRatesService.getAll();
    }

    @PostMapping("save")
    private ExchangeRates save(@RequestBody ExchangeRates exchangeRates) {
        return exchangeRatesService.save(exchangeRates);
    }

    @DeleteMapping("delete")
    private void delete(@RequestParam("id") String id) {
        exchangeRatesService.delete(Long.parseLong(id));
    }
}
