package Docker.Stok.Stok.service;
import Docker.Stok.Stok.model.Item;
import Docker.Stok.Stok.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    //LISTAR
    public List<Item> getAll() {return itemRepository.findAll();}
    //CRIAR
    public Item save(Item item) {return itemRepository.save(item);}
    //DELETAR
    public void delete(Long id){itemRepository.deleteById(id);}


}
