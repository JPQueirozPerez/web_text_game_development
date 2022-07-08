package main.com.company.servicejpa;

import main.com.company.model.NPC;
import main.com.company.model.Player;
import main.com.company.repository.RepositoryChar;
import main.com.company.repository.RepositoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;
@Service
public class ServiceCharacterJPA {

    @Autowired
    private RepositoryChar repoChar;

    private  static RepositoryChar repoC;




    @PostConstruct
    public void init(){
        this.repoC = repoChar;


    }

    public Player findBycharClass(String name, String charClass ){
        Optional<Player> p = repoC.findBycharClass(charClass);
        Player k = p.get();
        k.setName(name);
        return k;
    }

    public NPC findbyChoise(int choice){
        Optional<NPC> o = repoC.findByChoise(choice);
        NPC n = o.get();
        return n;
    }

    public Iterable<Player> findAllClasses(){
        Iterable<Player> charClasses = repoC.findAllPlayer();
        return charClasses;
    }

    public Player update(String charClass, Player player){
        Optional<Player> player2 = repoChar.findBycharClass(charClass);
        Player player3 = player2.get();
        if(player3!=null){
//            the wishes of the front-end
            return repoChar.save(player3);
        }
        return null;

    }

    public NPC update(String name, NPC npc){
        Optional<NPC> npc2 = repoChar.findByName(name);
        NPC npc3 = npc2.get();
        if(npc3!=null){
//            the wishes of the front-end
            return repoChar.save(npc3);
        }
        return null;

    }





}
