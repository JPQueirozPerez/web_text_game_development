package main.com.company.controllerRest;

import main.com.company.model.Item;
import main.com.company.repository.RepositoryItem;
import main.com.company.servicejpa.ServiceItemJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemRest {

    @Autowired
    ServiceItemJPA serviceItemJPA;

    @Autowired
    RepositoryItem repoItem;

    //---------------------------Rest Item------------------------------------------//

    @GetMapping("/{name}")
    public Item getByName(@PathVariable String name){
        Optional<Item>  item = repoItem.findByName(name);
        return item.get();
    }

    @PostMapping("/add")
    public Item save(@RequestBody Item item){
        return repoItem.save(item);
    }

    @PutMapping("/update/{name}")
    public  Item update(@PathVariable String name, @RequestBody Item item){
        return serviceItemJPA.update(name,item);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<Void> delete(@PathVariable("name") String name) {
        serviceItemJPA.deleteByName(name);
        return ResponseEntity.noContent().build();
    }
    //---------------------------Rest Item------------------------------------------//




}
