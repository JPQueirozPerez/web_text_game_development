package main.com.company.servicejpa;

import main.com.company.model.EquippableItem;
import main.com.company.model.Exceptions;
import main.com.company.model.Item;
import main.com.company.model.Player;
import main.com.company.repository.RepositoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class ServiceItemJPA {

    @Autowired
    private RepositoryItem repoeitem;



    private static RepositoryItem repoei;

    @PostConstruct
    public void init(){
        this.repoei = repoeitem;

    }

    public EquippableItem findbyChoise(int choise){
        Optional<EquippableItem> o = repoei.findByChoise(choise);
        EquippableItem n = o.get();
        return n;
    }

    public Item getItem(Player p ){
        Optional<Item>  i = repoei.findByName(p.getNameItem());
        return i.get();

    }

    public void deleteByName(String name){
        Optional<Item> item = repoeitem.findByName(name);
        if (item.get()==null) {
            throw new Exceptions("Item not found", HttpStatus.NOT_FOUND);
        }

        repoeitem.delete(item.get());
    }

    public Item update(String name,Item item){
        Optional<Item> item2 = repoeitem.findByName(name);
        Item item3 = item2.get();
        if(item3!=null){
//            the wishes of the front-end
            return repoeitem.save(item3);
        }
        return null;

    }
}
