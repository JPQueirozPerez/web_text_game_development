package main.com.company.controller;

import main.com.company.model.EquippableItem;
import main.com.company.model.Item;
import main.com.company.model.Player;
import main.com.company.model.UsableItem;
import main.com.company.service.CraftService;
import main.com.company.service.InventoryService;
import main.com.company.servicejpa.ServiceItemJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.List;
@Controller
public class CraftController {


    @Autowired
    private ServiceItemJPA serviceEitem;

    private  static ServiceItemJPA sp;



    @PostConstruct
    public void init(){
        this.sp = serviceEitem;

    }


    public static void crafting(Player player, int value, int craftQuantity) {
        List<Item> inventory = player.getInventory().getItems();
        Item ingredientItem = null;
        int quantity = 0;
        String ingredientName;


        switch (value) {
            case 1: {
                ingredientName = "Healing herb";
                ingredientItem = InventoryService.searchItemByName(inventory,ingredientName);
                if(ingredientItem != null) quantity = ingredientItem.getQuantity();
                if(CraftService.checkEnoughIngredients(quantity,5,craftQuantity,ingredientName,"Health potion")){
                    UsableItem craftedItem = sp.findByNameMultiply("Health potion");
                    CraftService.crafting(player, 5 * craftQuantity, craftedItem, ingredientItem, craftQuantity);
                }
                break;
            }
            case 2: {
                ingredientName = "Clay";
                ingredientItem = InventoryService.searchItemByName(inventory,ingredientName);
                if(ingredientItem != null) quantity = ingredientItem.getQuantity();
                if(CraftService.checkEnoughIngredients(quantity,10,craftQuantity,ingredientName,"Golem arm")) {
                    Item craftedItem = sp.findByNameMultiply("Golem arm");
                    CraftService.crafting(player, 10 * craftQuantity, craftedItem, ingredientItem, craftQuantity);
                }
                break;
            }
            case 3: {
                ingredientName = "Clay";
                ingredientItem = InventoryService.searchItemByName(inventory,ingredientName);
                if(ingredientItem != null) quantity = ingredientItem.getQuantity();
                if(CraftService.checkEnoughIngredients(quantity,10,craftQuantity,ingredientName,"Golem leg")) {
                    Item craftedItem = sp.findByNameMultiply("Golem leg");
                    CraftService.crafting(player, 10 * craftQuantity, craftedItem, ingredientItem, craftQuantity);
                }
                break;
            }
            case 4: {
                ingredientName = "Clay";
                ingredientItem = InventoryService.searchItemByName(inventory,ingredientName);
                if(ingredientItem != null) quantity = ingredientItem.getQuantity();
                if(CraftService.checkEnoughIngredients(quantity,10,craftQuantity,ingredientName,"Golem head")) {
                    Item craftedItem = sp.findByNameMultiply("Golem head");
                    CraftService.crafting(player, 10 * craftQuantity, craftedItem, ingredientItem, craftQuantity);
                }
                break;
            }
            case 5: {
                ingredientName = "Clay";
                ingredientItem = InventoryService.searchItemByName(inventory,ingredientName);
                if(ingredientItem != null) quantity = ingredientItem.getQuantity();
                if(CraftService.checkEnoughIngredients(quantity,20,craftQuantity,ingredientName,"Golem body")) {
                    Item craftedItem = sp.findByNameMultiply("Golem body");
                    CraftService.crafting(player, 20 * craftQuantity, craftedItem, ingredientItem, craftQuantity);
                }
                break;
            }
            case 6: {
                ingredientName = "Fur";
                ingredientItem = InventoryService.searchItemByName(inventory,ingredientName);
                if(ingredientItem != null) quantity = ingredientItem.getQuantity();
                if(CraftService.checkEnoughIngredients(quantity,1,craftQuantity,ingredientName,"Leather")) {
                    Item craftedItem = sp.findByNameMultiply("Leather");
                    CraftService.crafting(player,craftQuantity, craftedItem, ingredientItem, craftQuantity);
                }
                break;
            }
            case 7: {
                ingredientName = "Leather";
                ingredientItem = InventoryService.searchItemByName(inventory,ingredientName);
                if(ingredientItem != null) quantity = ingredientItem.getQuantity();
                if(CraftService.checkEnoughIngredients(quantity,3,craftQuantity,ingredientName,"Leather helmet")) {
                    EquippableItem craftedItem = sp.findByNameMultiply("Leather helmet");
                    CraftService.crafting(player, 3 * craftQuantity, craftedItem, ingredientItem, craftQuantity);
                }
                break;
            }
            case 8: {
                ingredientName = "Leather";
                ingredientItem = InventoryService.searchItemByName(inventory,ingredientName);
                if(ingredientItem != null) quantity = ingredientItem.getQuantity();
                if(CraftService.checkEnoughIngredients(quantity,4,craftQuantity,ingredientName,"Leather gloves")) {
                    EquippableItem craftedItem = sp.findByNameMultiply("Leather gloves");
                    CraftService.crafting(player, 4 * craftQuantity, craftedItem, ingredientItem, craftQuantity);
                }
                break;
            }
            case 9: {
                ingredientName = "Leather";
                ingredientItem = InventoryService.searchItemByName(inventory,ingredientName);
                if(ingredientItem != null) quantity = ingredientItem.getQuantity();
                if(CraftService.checkEnoughIngredients(quantity,4,craftQuantity,ingredientName,"Leather boots")) {
                    EquippableItem craftedItem = sp.findByNameMultiply("Leather boots");
                    CraftService.crafting(player, 4 * craftQuantity, craftedItem, ingredientItem, craftQuantity);
                }
                break;
            }
            case 10: {
                ingredientName = "Leather";
                ingredientItem = InventoryService.searchItemByName(inventory,ingredientName);
                if(ingredientItem != null) quantity = ingredientItem.getQuantity();
                if(CraftService.checkEnoughIngredients(quantity,7,craftQuantity,ingredientName,"Leather armour")) {
                    EquippableItem craftedItem = sp.findByNameMultiply("Leather armour");
                    CraftService.crafting(player, 7 * craftQuantity, craftedItem, ingredientItem, craftQuantity);
                }
                break;
            }
        }
    }
}
