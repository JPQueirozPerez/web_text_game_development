package main.com.company.service;

import main.com.company.model.*;
import main.com.company.controller.InventoryController;

import main.com.company.servicejpa.ServiceItemJPA;
import main.com.company.view.InventoryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Controller
public class InventoryService {


    @Autowired
    private ServiceItemJPA serviceEitem;

    private  static ServiceItemJPA sp;

    @PostConstruct
    public void init(){
        this.sp = serviceEitem;

    }


   public static Item createItem() {
        int value = new Random().nextInt(1, 20);
        //the value 5-6 provide the error
        return sp.findByChoiseMultiply(value);
    }

    public static boolean compareItems(List<Item> items, Item newItemToAdd) {
        String name = newItemToAdd.getName();
        return searchItemByName(items, name) != null;
    }

    public static void equippingOrUsingObject(Player player, int option) {
        List<Item> items = new ArrayList<>(player.getInventory().getItems());
        Item item = searchItem(items,option);
        if (!((item.getClass() == EquippableItem.class) || (item.getClass() == UsableItem.class))) InventoryView.inventoryMessage(2, item);
        else {
            InventoryView.inventoryMessage(1, item);
            InventoryController.removeItemFromInventory(player.getInventory(), item, 1);
            if (item.getClass() == EquippableItem.class) EquipmentService.equippingPlayer(player, item);
            else ItemService.usingItem(player, item);
        }
    }



    public static Item searchItem(List<Item> items, int itemIndex) {
        return items.stream()
                .filter(i -> i.getIndex() == itemIndex)
                .findAny()
                .orElse(null);
    }
    public static Item searchItemByName (List<Item> items, String name){
        return items.stream()
                .filter(i -> i.getName().equals(name))
                .findAny()
                .orElse(null);
    }
}








