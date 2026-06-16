package Docker.Stok.Stok.repository;

import Docker.Stok.Stok.model.Item;
import org.aspectj.apache.bcel.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long > {

}
