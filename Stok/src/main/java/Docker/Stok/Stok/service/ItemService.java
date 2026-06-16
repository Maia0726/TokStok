package Docker.Stok.Stok.service;
import Docker.Stok.Stok.model.Item;
import Docker.Stok.Stok.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    //LISTAR
    public List<Item> getAll() {return itemRepository.findAll();}
    //CRIAR\ATUALIZAR
    public Item save(Item item) {return itemRepository.save(item);}
    //DELETAR
    public void delete(Long id){itemRepository.deleteById(id);}
    // BUSCAR POR ID
    public Optional<Item> findById(Long id) {return itemRepository.findById(id);}

}
