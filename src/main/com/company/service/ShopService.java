package main.com.company.service;

import main.com.company.model.Inventory;
import main.com.company.model.Item;
import main.com.company.model.Player;
import main.com.company.controller.InventoryController;
import main.com.company.view.CharacterView;
import main.com.company.view.ShopView;

import java.util.ArrayList;
import java.util.List;

public class ShopService {

    public static int itemPriceCalculation(int value, Item item) {
        int totalPrice;
        if (value == 1) totalPrice = item.getPrice() + 2;
        else {
            if (item.getPrice() >= 3) totalPrice = item.getPrice() - 2;
            else totalPrice = 1;
        }
        return totalPrice;
    }

    public static void shopping(int value, Inventory shopInventory, int itemIndex, Player player, int quantity) {
        List<Item> items = new ArrayList<>(player.getInventory().getItems());
        List<Item> shopItems = new ArrayList<>(shopInventory.getItems());
        if (value != 1) {
            Item item = InventoryService.searchItem(items,itemIndex);
            if (player.getInventory().getItems().get(itemIndex-1).getQuantity() < quantity)
                ShopView.shopMessage(3, item.getName(), 0, quantity);
            else {
                int price = itemPriceCalculation(2, item) * quantity;
                ShopView.shopMessage(1, item.getName(), price, quantity);
                InventoryController.removeItemFromInventory(player.getInventory(), item, quantity);
                for (int i = 0; i < quantity; i++) { //TODO
                    InventoryController.addItemToInventory(shopInventory, item);
                }
                player.setMoney(player.getMoney() + price);
                CharacterView.moneyMessage("2", player, null);
            }
        } else {
            Item item = InventoryService.searchItem(shopItems,itemIndex);
            int price = itemPriceCalculation(1, item) * quantity;
            if (player.getMoney() < price || player.getInventory().getCapacity() < quantity)
                ShopView.shopMessage(2, item.getName(), price, quantity);
            else {
                ShopView.shopMessage(1, item.getName(), price, quantity);
                InventoryController.removeItemFromInventory(shopInventory, item, quantity);
                for (int i = 0; i < quantity; i++) { //TODO
                    InventoryController.addItemToInventory(player.getInventory(), item);
                }
                System.out.println(shopInventory.getItems());
                player.setMoney(player.getMoney() - price);
                CharacterView.moneyMessage("2", player, null);
            }
        }
    }

}
