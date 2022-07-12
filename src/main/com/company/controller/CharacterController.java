package main.com.company.controller;


import main.com.company.model.*;
import main.com.company.service.CharacterService;
import main.com.company.servicejpa.ServiceCharacterJPA;
import main.com.company.servicejpa.ServiceItemJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Random;

import static main.com.company.service.InventoryService.createItem;
@Controller
public class CharacterController {

    @Autowired
    private ServiceCharacterJPA servChar;
    @Autowired
    private ServiceItemJPA servItem;

    private  static ServiceCharacterJPA sc;

    private  static ServiceItemJPA si;


    @PostConstruct
    public void init(){
        this.sc = servChar;
        this.si = servItem;
    }


    public static Player createPlayer(String name, String charClass) {


        Player p1 = sc.findBycharClass(name,charClass);
        Item item = si.getItem(p1);
        p1.setEquipment(new Equipment(0, 0, 0, 0, new ArrayList<>()));
        Inventory inventory = new Inventory(10, new ArrayList<>());
        Player p2  = CharacterService.createPlayer(new ArrayList<>(), item,p1,inventory);
        return p2;
    }

    public static NPC createEnemyPlaceholder(int playerLevel) {

        int value = new Random().nextInt(1, 12);
        NPC npc =  sc.findbyChoice(value);

        if(npc.getCharClass().equals("beast")){
            Item fur = new Item("Fur", "material", "The fur of an wild animal", 1, 1);
            npc.setTreasure(fur);
            return npc;
        }else if(npc.getCharClass().equals("golem")){
            Item clay = new Item("Clay", "material", "A handful of clay", 1, 1);
            npc.setTreasure(clay);
            return npc;
        }


        Item i = createItem();
        npc.setTreasure(i);
        return npc;


    }

    public static int enemyLevelCalculation(int playerLevel){
        int level;
        if (!(playerLevel < 4)) {
            return level = new Random().nextInt((playerLevel - 3), (playerLevel + 4));
        } else {
            return level = new Random().nextInt( 1, playerLevel+4);
        }
    }

}



