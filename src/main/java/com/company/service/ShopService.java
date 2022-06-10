package com.company.service;

import com.company.model.Inventory;
import com.company.model.Item;
import com.company.model.Player;

import java.util.ArrayList;
import java.util.List;

import static com.company.controller.InventoryController.addItemToInventory;
import static com.company.controller.InventoryController.removeItemFromInventory;
import static com.company.view.CharacterView.moneyMessage;
import static com.company.view.ShopView.shopMessage;

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
                shopMessage(3, item.getName(), 0, quantity);
            else {
                int price = itemPriceCalculation(2, item) * quantity;
                shopMessage(1, item.getName(), price, quantity);
                for (int i = 0; i < quantity; i++) { //to do
                    addItemToInventory(shopInventory.getItems(), shopInventory, item);
                }
                removeItemFromInventory(player.getInventory(), item, quantity);
                player.setMoney(player.getMoney() + price);
                moneyMessage("2", player, null);
            }
        } else {
            Item item = InventoryService.searchItem(shopItems,itemIndex);
            int price = itemPriceCalculation(1, item) * quantity;
            if (player.getMoney() < price || player.getInventory().getCapacity() < quantity)
                shopMessage(2, item.getName(), price, quantity);
            else {
                shopMessage(1, item.getName(), price, quantity);
                for (int i = 0; i < quantity; i++) { //to do
                    addItemToInventory(player.getInventory().getItems(), player.getInventory(), item);
                }
                removeItemFromInventory(shopInventory, item, quantity);
                player.setMoney(player.getMoney() - price);
                moneyMessage("2", player, null);
            }
        }
    }

}
