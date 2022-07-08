package main.com.company.service;

import main.com.company.model.Item;
import main.com.company.model.Player;
import main.com.company.controller.InventoryController;
import main.com.company.view.CraftView;
import org.springframework.stereotype.Service;

@Service
public class CraftService {

    public static void crafting(Player player, int necessaryQuantity, Item craftedItem, Item ingredientItem, int craftQuantity) {
        for (int i = 0; i < craftQuantity; i++) {
            InventoryController.addItemToInventory(player.getInventory().getItems(), player.getInventory(), craftedItem);
        }
        InventoryController.removeItemFromInventory(player.getInventory(), ingredientItem, necessaryQuantity);
    }

    public static boolean checkEnoughIngredients(int inventoryQuantity, int necessaryQuantity, int craftQuantity, String ingredientName, String craftedItemName) {
        if (inventoryQuantity < necessaryQuantity * craftQuantity){
            CraftView.craftingMessages(1, craftedItemName, inventoryQuantity, necessaryQuantity, ingredientName, craftQuantity);
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
