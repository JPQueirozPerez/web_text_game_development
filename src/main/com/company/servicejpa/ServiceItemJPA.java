package main.com.company.servicejpa;

import main.com.company.model.EquippableItem;
import main.com.company.model.Item;
import main.com.company.model.Player;
import main.com.company.repository.RepositoryItem;
import org.springframework.beans.factory.annotation.Autowired;
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



    public EquippableItem findbyChoice(int choice){
        Optional<EquippableItem> o = repoei.findByChoice(choice);
        EquippableItem n = o.get();
        return n;
    }

    public Item getItem(Player p ){
        Optional<Item>  i = repoei.findByName(p.getNameItem());
        return i.get();

    }


}
