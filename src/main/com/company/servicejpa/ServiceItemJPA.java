package main.com.company.servicejpa;

import main.com.company.model.*;
import main.com.company.repository.RepositoryItem;
import main.com.company.service.CraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;
import java.util.stream.Stream;

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
        Optional<EquippableItem> o = repoei.findByChoiseE(choise);
        EquippableItem n = o.get();
        return n;
    }

//    public Object findbyChoise(int choise){
//        Optional<Object> o = repoei.findByChoseMultiply(choise);
//        return o.get();
//    }

    public UsableItem findbyChoiseUsable(int choise){
        Optional<UsableItem> o = repoei.findByChoiseU(choise);
        UsableItem n = o.get();
        return n;
    }

    public <T> T findByNameMultiply(String name){

        if (Stream.of("Great armour","Helmet","Tunic","Wooden stick",
                "Sword","Bow","Dagger","Leather helmet","Leather gloves",
                "Leather boots","Leather armour").anyMatch(x -> name.equals(x))) {
            EquippableItem item= repoei.findByNameE(name).get();
            return (T) item;
        }

        if (Stream.of("Health potion","Healing herb").anyMatch(x -> name.equals(x))) {
            UsableItem item= repoei.findByNameU(name).get();
            return (T) item;
        }

        if (Stream.of("Golem arm","Golem leg","Golem head","Golem body","Leather","Fur",
                        "Clay").anyMatch(x -> name.equals(x))) {
            Item item= repoei.findByName(name).get();
            return (T) item;
        }
        return null;


//        Optional<Object> o = repoei.findByNameMultiply(name);
//        if (o.get() instanceof Item){
//            return (T) o.get();
//        }
//        if (o.get() instanceof EquippableItem){
//            return (T) o.get();
//        }
//        if (o.get() instanceof UsableItem){
//            return (T) o.get();
//        }
//        return null ;
    }

    public Item findByChoiseMultiply(int choise){

        if (Stream.of(1,2,3,4,5,6,7,8,9,10,11).anyMatch(x -> x == choise)) {
           EquippableItem item= repoei.findByChoiseE(choise).get();
           return  item;
        }

        if (Stream.of(12,13).anyMatch(x -> x == choise)) {
            UsableItem item= repoei.findByChoiseU(choise).get();
            return  item;
        }

        if (Stream.of(14,15,16,17,18,19,20).anyMatch(x -> x == choise)) {
            Item item= repoei.findByChoiseI(choise).get();
            return item;
        }
        return null;
    }



    public Item getItem(Player p ){
        Optional<Item>  i = repoei.findByName(p.getNameItem());
        return i.get();

    }

    public void deleteByName(String name){
        Optional<Item> item = repoei.findByName(name);
        if (item.get()==null) {
            throw new Exceptions("Item not found", HttpStatus.NOT_FOUND);
        }

        repoeitem.delete(item.get());
    }

    public Item update(String name,Item item){
        Optional<Item> item2 = repoei.findByName(name);
        Item item3 = item2.get();
        if(item3!=null){
//            the wishes of the front-end
            return repoeitem.save(item3);
        }
        return null;

    }
}
