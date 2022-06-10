package com.company.service;

import com.company.model.Item;
import com.company.model.Player;

import static com.company.controller.InventoryController.addItemToInventory;
import static com.company.controller.InventoryController.removeItemFromInventory;
import static com.company.view.CraftView.craftingMessages;

public class CraftService {

    public static void crafting(Player player, int necessaryQuantity,Item craftedItem, Item ingredientItem, int craftQuantity) {
        for (int i = 0; i < craftQuantity; i++) {
            addItemToInventory(player.getInventory().getItems(), player.getInventory(), craftedItem);
        }
        removeItemFromInventory(player.getInventory(), ingredientItem, necessaryQuantity);
    }

    public static boolean checkEnoughIngredients(int inventoryQuantity, int necessaryQuantity, int craftQuantity, String ingredientName, String craftedItemName) {
        if (inventoryQuantity < necessaryQuantity * craftQuantity){
            craftingMessages(1, craftedItemName, inventoryQuantity, necessaryQuantity, ingredientName, craftQuantity);
            return false;
        }
        return true;
    }

    public static boolean checkEnougthIngredients(int inventoryQuantity, int necessaryQuantity, int craftQuantity) {
        if (inventoryQuantity < necessaryQuantity * craftQuantity){
            return false;
        }
        return true;
    }
}
