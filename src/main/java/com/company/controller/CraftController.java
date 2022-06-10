package com.company.controller;

import com.company.model.EquippableItem;
import com.company.model.Item;
import com.company.model.Player;
import com.company.model.UsableItem;
import com.company.service.CraftService;
import com.company.service.InventoryService;

import java.util.List;

public class CraftController {

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
                    UsableItem craftedItem = new UsableItem("Health potion", "Potion", "A potion with medicinal capabilities",5,craftQuantity,"heal some HP",10);
                    CraftService.crafting(player, 5 * craftQuantity, craftedItem, ingredientItem, craftQuantity);
                    //CraftService.crafting(player, quantity, 5, "Health potion", "A potion with medicinal capabilities", 5, ingredientItem, ingredientName, "Potion", 0, 0, 0, craftQuantity, false, true);
                }
                break;
            }
            case 2: {
                ingredientName = "Clay";
                ingredientItem = InventoryService.searchItemByName(inventory,ingredientName);
                if(ingredientItem != null) quantity = ingredientItem.getQuantity();
                if(CraftService.checkEnoughIngredients(quantity,10,craftQuantity,ingredientName,"Golem arm")) {
                    Item craftedItem = new Item("Golem arm", "Constructor", "The arm of a Golem", 20, craftQuantity);
                    CraftService.crafting(player, 10 * craftQuantity, craftedItem, ingredientItem, craftQuantity);
                    //CraftService.crafting(player, quantity, 10, "Golem arm", "The arm of a Golem", 20, ingredientItem, ingredientName, "Constructor", 0, 0, 0, craftQuantity, false, false);
                }
                break;
            }
            case 3: {
                ingredientName = "Clay";
                ingredientItem = InventoryService.searchItemByName(inventory,ingredientName);
                if(ingredientItem != null) quantity = ingredientItem.getQuantity();
                if(CraftService.checkEnoughIngredients(quantity,10,craftQuantity,ingredientName,"Golem leg")) {
                    Item craftedItem = new Item("Golem leg", "Constructor", "The leg of a Golem", 20, craftQuantity);
                    CraftService.crafting(player, 10 * craftQuantity, craftedItem, ingredientItem, craftQuantity);
                    //CraftService.crafting(player, quantity, 10, "Golem leg", "The leg of a Golem", 20, ingredientItem, ingredientName, "Constructor", 0, 0, 0, craftQuantity, false, false);
                }
                break;
            }
            case 4: {
                ingredientName = "Clay";
                ingredientItem = InventoryService.searchItemByName(inventory,ingredientName);
                if(ingredientItem != null) quantity = ingredientItem.getQuantity();
                if(CraftService.checkEnoughIngredients(quantity,10,craftQuantity,ingredientName,"Golem head")) {
                    Item craftedItem = new Item("Golem head", "Constructor", "The head of a Golem", 20, craftQuantity);
                    CraftService.crafting(player, 10 * craftQuantity, craftedItem, ingredientItem, craftQuantity);
//                CraftService.crafting(player, quantity, 10, "Golem head", "The head of a Golem", 20, ingredientItem, ingredientName, "Constructor", 0, 0, 0, craftQuantity, false, false);
                }
                break;
            }
            case 5: {
                ingredientName = "Clay";
                ingredientItem = InventoryService.searchItemByName(inventory,ingredientName);
                if(ingredientItem != null) quantity = ingredientItem.getQuantity();
                if(CraftService.checkEnoughIngredients(quantity,20,craftQuantity,ingredientName,"Golem body")) {
                    Item craftedItem = new Item("Golem body", "Constructor", "The body of a Golem", 40, craftQuantity);
                    CraftService.crafting(player, 20 * craftQuantity, craftedItem, ingredientItem, craftQuantity);
//                CraftService.crafting(player, quantity, 20, "Golem body", "The body of a Golem", 40, ingredientItem, ingredientName, "Constructor", 0, 0, 0, craftQuantity, false, false);
                }
                break;
            }
            case 6: {
                ingredientName = "Fur";
                ingredientItem = InventoryService.searchItemByName(inventory,ingredientName);
                if(ingredientItem != null) quantity = ingredientItem.getQuantity();
                if(CraftService.checkEnoughIngredients(quantity,1,craftQuantity,ingredientName,"Leather")) {
                    Item craftedItem = new Item("Leather",  "Material", "A piece of leather", 2, craftQuantity);
                    CraftService.crafting(player,craftQuantity, craftedItem, ingredientItem, craftQuantity);
//                CraftService.crafting(player, quantity, 1, "Leather", "A piece of leather", 2, ingredientItem, ingredientName, "Material", 0, 0, 0, craftQuantity, false, false);
                }
                break;
            }
            case 7: {
                ingredientName = "Leather";
                ingredientItem = InventoryService.searchItemByName(inventory,ingredientName);
                if(ingredientItem != null) quantity = ingredientItem.getQuantity();
                if(CraftService.checkEnoughIngredients(quantity,3,craftQuantity,ingredientName,"Leather helmet")) {
                    EquippableItem craftedItem = new EquippableItem("Leather helmet", "armour", "A basic helmet made of leather", 4, craftQuantity,0,0,2,0,0);
                    CraftService.crafting(player, 3 * craftQuantity, craftedItem, ingredientItem, craftQuantity);
//                CraftService.crafting(player, quantity, 3, "Leather helmet", "A basic helmet made of leather", 4, ingredientItem, ingredientName, "armour", 0, 2, 0, craftQuantity, true, false);
                }
                break;
            }
            case 8: {
                ingredientName = "Leather";
                ingredientItem = InventoryService.searchItemByName(inventory,ingredientName);
                if(ingredientItem != null) quantity = ingredientItem.getQuantity();
                if(CraftService.checkEnoughIngredients(quantity,4,craftQuantity,ingredientName,"Leather gloves")) {
                    EquippableItem craftedItem = new EquippableItem("Leather gloves", "armour", "A basic pair of gloves made of leather", 4, craftQuantity,0,0,2,0,0);
                    CraftService.crafting(player, 4 * craftQuantity, craftedItem, ingredientItem, craftQuantity);
//                CraftService.crafting(player, quantity, 4, "Leather gloves", "A basic pair of gloves made of leather", 4, ingredientItem, ingredientName, "armour", 0, 2, 0, craftQuantity, true, false);
                }
                break;
            }
            case 9: {
                ingredientName = "Leather";
                ingredientItem = InventoryService.searchItemByName(inventory,ingredientName);
                if(ingredientItem != null) quantity = ingredientItem.getQuantity();
                if(CraftService.checkEnoughIngredients(quantity,4,craftQuantity,ingredientName,"Leather boots")) {
                    EquippableItem craftedItem = new EquippableItem("Leather boots", "armour", "A basic pair of boots made of leather", 4, craftQuantity,0,0,2,0,0);
                    CraftService.crafting(player, 4 * craftQuantity, craftedItem, ingredientItem, craftQuantity);
//                CraftService.crafting(player, quantity, 4, "Leather boots", "A basic pair of boots made of leather", 4, ingredientItem, ingredientName, "armour", 0, 2, 0, craftQuantity, true, false);
                }
                break;
            }
            case 10: {
                ingredientName = "Leather";
                ingredientItem = InventoryService.searchItemByName(inventory,ingredientName);
                if(ingredientItem != null) quantity = ingredientItem.getQuantity();
                if(CraftService.checkEnoughIngredients(quantity,7,craftQuantity,ingredientName,"Leather armour")) {
                    EquippableItem craftedItem = new EquippableItem("Leather armour", "armour", "A basic armour made of leather", 6, craftQuantity,0,0,4,0,0);
                    CraftService.crafting(player, 7 * craftQuantity, craftedItem, ingredientItem, craftQuantity);
//                CraftService.crafting(player, quantity, 7, "Leather armour", "A basic armour made of leather", 6, ingredientItem, ingredientName, "armour", 0, 4, 0, craftQuantity, true, false);
                }
                break;
            }
        }
    }
}
