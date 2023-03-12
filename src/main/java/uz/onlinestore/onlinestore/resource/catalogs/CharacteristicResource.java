package uz.onlinestore.onlinestore.resource.catalogs;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.onlinestore.onlinestore.dto.CharacteristicDto;
import uz.onlinestore.onlinestore.models.catalogs.Characteristic;
import uz.onlinestore.onlinestore.service.catalogs.CharacteristicService;
import uz.onlinestore.onlinestore.service.catalogs.ProductService;

import java.util.List;

@RestController
@RequestMapping("/online/doc/characteristic/")
@RequiredArgsConstructor
public class CharacteristicResource {

    @Autowired
    private final CharacteristicService characteristicService;
    @Autowired
    private final ProductService productService;

    @GetMapping("get")
    private List<CharacteristicDto> getByProductId(@RequestParam("id") String id) {
        return characteristicService.getAllDto(Long.parseLong(id));
    }


//    @PostMapping("addcharacter")
//    private Product saveCharacter(@RequestParam("id") String id, @RequestBody Characteristic characteristic) {
//        return characteristicService.saveCharacteristic(Long.parseLong(id), characteristic);
//    }

    @PostMapping("save")
    private Characteristic saveCharacter(@RequestBody Characteristic characteristics) {
        return characteristicService.save(characteristics);
    }

    @DeleteMapping("removecharacter")
    private void saveCharacter(@RequestParam("id") String id) {
        characteristicService.removeCharacteristic(Long.parseLong(id));
    }
}
