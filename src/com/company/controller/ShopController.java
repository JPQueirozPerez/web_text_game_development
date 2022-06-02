package com.company.controller;

import com.company.model.Inventory;
import com.company.model.Item;
import com.company.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.company.service.InventoryService.compareItems;
import static com.company.service.InventoryService.createItem;
import static com.company.view.ShopView.*;

public class ShopController {

    public static void shopping(Player player, int value) {
        List<Item> items = new ArrayList<Item>(200);
        Inventory shopInventory = new Inventory(items, 200);
        for (int i = 0; i < 100; i++) {
            Item newItem = createItem();
            if (compareItems(shopInventory.getItems(), newItem)) shopInventory.getItems().
                items.replace(newItem, items.get(newItem) + 1);
            else items.put(newItem, 1);
            shopInventory.setItems(items);
            shopInventory.setCapacity(shopInventory.getCapacity() - 1);
        }
        if (value != 1) buyingAndSelling(shopInventory, player, 2);
        else buyingAndSelling(shopInventory, player, 1);
    }
}
