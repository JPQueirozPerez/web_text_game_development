package main.com.company.service;

import main.com.company.controller.InventoryController;
import main.com.company.model.Item;
import main.com.company.model.Player;
import main.com.company.model.UsableItem;

public class ItemService {

    static void usingItem(Player player, Item item) {
        UsableItem itemUse = (UsableItem) item;
        switch (itemUse.getUse()){
            case "healing": restoring(player, itemUse);
        }

    }

    private static void restoring(Player player, UsableItem item){
        if(item.getUse().equals("healing")) {
            if(player.getHealthPoints()!= player.getMaxHealthPoints()) {
                InventoryController.removeItemFromInventory(player.getInventory(), item, 1);
                if(player.getHealthPoints()+item.getValue()<player.getMaxHealthPoints()) {
                    player.setHealthPoints(player.getHealthPoints()+item.getValue());
                    System.out.println("Now you have "+player.getHealthPoints()+" health points");
                }else{
                    System.out.println("You have restored all your health points!");
                    player.setHealthPoints(player.getMaxHealthPoints());
                }
            } else System.out.println("You have already full health points!");
        }
    }

    private static void changeStatus(Player player, UsableItem item){

    }
}
