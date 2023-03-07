package uz.onlinestore.onlinestore.resource.calculate;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.onlinestore.onlinestore.models.calculate.Price;
import uz.onlinestore.onlinestore.service.calculate.PriceService;

import java.util.List;

@RestController
@RequestMapping("/online/doc/price/")
@RequiredArgsConstructor
public class PriceResource {

    @Autowired
    private PriceService priceService;


    @GetMapping("get")
    private List<Price> getAll() {
        return priceService.getAll();
    }

    @PostMapping("save")
    private Price save(@RequestBody Price Price) {
        return priceService.save(Price);
    }

    @DeleteMapping("delete")
    private void delete(@RequestParam("id") String id) {
        priceService.delete(Long.parseLong(id));
    }
}
