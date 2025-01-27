package main.com.company.controller;

import main.com.company.model.*;
import main.com.company.service.CraftService;
import main.com.company.service.InventoryService;
import main.com.company.servicejpa.ServiceCraftJPA;
import main.com.company.servicejpa.ServiceItemJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//import javax.annotation.CheckForNull;
import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Stream;

@Controller
public class CraftController {


    @Autowired
    private ServiceCraftJPA serviceCraft;
    private  static ServiceCraftJPA sc;

    @Autowired
    private ServiceItemJPA serviceEitem;

    private  static ServiceItemJPA sp;



    @PostConstruct
    public void init(){
        this.sc = serviceCraft;
        this.sp = serviceEitem;

    }


    public static void crafting(Player player, int value, int craftQuantity) {
        List<Item> inventory = player.getInventory().getItems();
        int quantity = 0;

        ValuesCraftController vc = sc.findbyID(value);
        Item ingredientItem = InventoryService.searchItemByName(inventory,vc.getIngredientName());
        if(ingredientItem != null) quantity = ingredientItem.getQuantity();
        if(CraftService.checkEnoughIngredients(quantity,vc.getNecessaryQuantity(),craftQuantity,vc.getIngredientName(),vc.getCraftItemName())){



            if (Stream.of(1).anyMatch(x -> x == vc.getId())) {
                UsableItem craftedItem = sp.findByNameMultiply(vc.getCraftItemName());
                craftedItem.setQuantity(craftQuantity);
                CraftService.crafting(player, vc.getNecessaryQuantity() * craftQuantity,craftedItem , ingredientItem, craftQuantity);
            }

            if (Stream.of(2,3,4,5,6).anyMatch(x -> x == vc.getId())) {
                Item craftedItem = sp.findByNameMultiply(vc.getCraftItemName());
                craftedItem.setQuantity(craftQuantity);
                CraftService.crafting(player, vc.getNecessaryQuantity() * craftQuantity,craftedItem , ingredientItem, craftQuantity);
            }

            if (Stream.of(7,8,9,10).anyMatch(x -> x == vc.getId())) {
                EquippableItem craftedItem = sp.findByNameMultiply(vc.getCraftItemName());
                craftedItem.setQuantity(craftQuantity);
                CraftService.crafting(player, vc.getNecessaryQuantity() * craftQuantity,craftedItem , ingredientItem, craftQuantity);
            }


        }

    }
}