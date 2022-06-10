package com.company.service;

import com.company.model.EquippableItem;
import com.company.model.Item;
import com.company.model.Player;
import com.company.model.UsableItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.company.controller.InventoryController.removeItemFromInventory;
import static com.company.service.EquipmentService.equippingPlayer;
import static com.company.view.InventoryView.inventoryMessage;

public class InventoryService {

    public static Item createItem() {
        int value = new Random().nextInt((8 - 1) + 1);

        var reward = new Item();
        switch (value) {
            case 1: {
                reward = new EquippableItem("Tunic", "cloth", "A simple tunic", 2, 1, 0, 0, 1, 0, 0);
                break;
            }

            case 2: {
                reward = new EquippableItem("Wooden stick", "weapon", "A simple stick made of wood", 1, 1, 0, 0, 0, 0, 1);
                break;
            }

            case 3: {
                reward = new EquippableItem("Sword", "weapon", "A simple sword", 7, 1, 0, 0, 0, 0, 4);
                break;
            }

            case 4: {
                reward = new EquippableItem("Bow", "weapon", "A simple bow", 4, 1, 0, 0, 0, 0, 2);
                break;
            }

            case 5: {
                reward = new EquippableItem("Great armour", "armour", "A heavy armour with a good defense", 15, 1, 0, 0, 10, -3, 0);
                break;
            }

            case 6: {
                reward = new EquippableItem("Helmet", "armour", "A basic iron helmet", 5, 1,0, 0, 2, 0, 0);
                break;
            }

            case 7: {
                reward = new EquippableItem("Dagger", "weapon", "A simple dagger", 3, 1, 0, 0, 0, 0, 2);
                break;
            }

            default: {
                reward = new UsableItem("Healing herb", "herb", "This herb has medicinal capabilities", 1, 1, "healing", 3);
                break;
            }
        }
        return reward;
    }

    public static boolean compareItems(List<Item> items, Item newItemToAdd) {
        String name = newItemToAdd.getName();
        return searchItemByName(items, name) != null;
    }

    public static void equippingOrUsingObject(Player player, int option) {
        List<Item> items = new ArrayList<>(player.getInventory().getItems());
        Item item = searchItem(items,option);
        if (!(item.getClass() == EquippableItem.class) || (item.getClass() == UsableItem.class)) inventoryMessage(2, item);
        else {
            inventoryMessage(1, item);
            removeItemFromInventory(player.getInventory(), item, 1);
            if (item.getClass() == EquippableItem.class) equippingPlayer(player, item);
            else if (item.getClass() == UsableItem.class)
                System.out.println(item.getName() + " used.");
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








