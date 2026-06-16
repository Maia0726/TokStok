package Docker.Stok.Stok.controller;

import Docker.Stok.Stok.model.Item;
import Docker.Stok.Stok.repository.ItemRepository;
import Docker.Stok.Stok.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    //Injeção de Dependencia
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getAll() {return itemService.getAll();}

    @PostMapping
    public Item create(@RequestBody Item item) {return itemService.save(item);}

}
