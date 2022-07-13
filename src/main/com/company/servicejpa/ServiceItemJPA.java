package main.com.company.servicejpa;

import main.com.company.model.*;
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
///
    public EquippableItem findbyChoiseEquippable(int choise){
        Optional<EquippableItem> o = repoei.findByChoiseEquippable(choise);
        EquippableItem n = o.get();
        return n;
    }

    public UsableItem findbyChoiseUsable(int choise){
        Optional<UsableItem> o = repoei.findByChoiseUsable(choise);
        UsableItem n = o.get();
        return n;
    }

    public <T> T findByNameMultiply(String name){
        Optional<Object> o = repoei.findByNameMultiply(name);
        if (o.get() instanceof Item){
            return (T) o.get();
        }
        if (o.get() instanceof EquippableItem){
            return (T) o.get();
        }
        if (o.get() instanceof UsableItem){
            return (T) o.get();
        }
        return null ;
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
