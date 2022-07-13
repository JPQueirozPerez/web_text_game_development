package main.com.company.servicejpa;

import main.com.company.model.*;
import main.com.company.repository.RepositoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

//import static com.sun.tools.classfile.Attribute.Exceptions;

@Service
public class ServiceItemJPA {

    @Autowired
    private RepositoryItem repoitem;



    private static RepositoryItem repoi;

    @PostConstruct
    public void init(){
        this.repoi = repoitem;

    }
    public EquippableItem findbyChoice(int choice){
        Optional<EquippableItem> o = repoi.findByChoice(choice);
        EquippableItem n = o.get();
        return n;
    }
//    ///
//    public EquippableItem findbyChoiceEquippable(int choice){
//        Optional<EquippableItem> o = repoei.findByChoiceEquippable(choice);
//        EquippableItem n = o.get();
//        return n;
//    }

//    public UsableItem findbyChoiceUsable(int choice){
//        Optional<UsableItem> o = repoei.findByChoiceUsable(choice);
//        UsableItem n = o.get();
//        return n;
//    }
//
    public <T> T findByNameMultiply(String name){
        Optional<Object> o = repoi.findByNameMultiply(name);
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
        Optional<Item>  i = repoi.findByName(p.getNameItem());
        return i.get();

    }

//    public void deleteByName(String name){
//        Optional<Item> item = repoi.findByName(name);
//        if (item.get()==null) {
//            throw new Exceptions("Item not found", HttpStatus.NOT_FOUND);
//        }
//
//        repoitem.delete(item.get());
//    }

    public Item update(String name,Item item){
        Optional<Item> item2 = repoi.findByName(name);
        Item item3 = item2.get();
        if(item3!=null){
//            the wishes of the front-end
            return repoitem.save(item3);
        }
        return null;

    }
}