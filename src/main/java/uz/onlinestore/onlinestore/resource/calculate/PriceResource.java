package uz.onlinestore.onlinestore.resource.calculate;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.onlinestore.onlinestore.models.calculate.Price;
import uz.onlinestore.onlinestore.service.calculate.PriceService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/online/doc/price/")
@RequiredArgsConstructor
public class PriceResource {

    @Autowired
    private PriceService priceService;


    @GetMapping("get")
    private List<Price> getAll(@RequestParam("id") String id) {
        return priceService.getAll(Long.parseLong(id)).stream().sorted((a,b) -> b.getDate().compareTo(a.getDate())).collect(Collectors.toList());
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
