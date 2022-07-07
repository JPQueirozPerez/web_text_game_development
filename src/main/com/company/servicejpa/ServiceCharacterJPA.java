package main.com.company.servicejpa;

import main.com.company.model.*;
import main.com.company.repository.RepositoryChar;
import main.com.company.repository.RepositoryEquipment;
import main.com.company.repository.RepositoryInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;
@Service
public class ServiceCharacterJPA {

    @Autowired
    private RepositoryChar repoChar;

    @Autowired
    private RepositoryInventory repoI;

    @Autowired
    private RepositoryEquipment repoE;



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

    public NPC findbyChoise(int choise){
        Optional<NPC> o = repoC.findByChoise(choise);
        NPC n = o.get();
        return n;
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

    public void deleteBycharClass(String charClass){
        Inventory i = new Inventory();
        Equipment e = new Equipment();
        Optional<Player> player = repoChar.findBycharClass(charClass);
        if (player.get()==null) {
            throw new Exceptions("player not found", HttpStatus.NOT_FOUND);
        }
        repoI.delete(player.get().getInventory());
        repoE.delete(player.get().getEquipment());
        player.get().setEquipment(e);
        player.get().setInventory(i);
        repoChar.delete(player.get());
    }
    public void deleteByname(String name){
        Optional<NPC> npc = repoChar.findByName(name);
        if (npc.get()==null) {
            throw new Exceptions("npc not found", HttpStatus.NOT_FOUND);
        }
        repoChar.delete(npc.get());
    }




}
