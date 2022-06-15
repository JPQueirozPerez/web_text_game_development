package main.com.company.controller;

import main.com.company.model.Inventory;
import main.com.company.model.Item;
import main.com.company.model.Player;
import main.com.company.view.ShopView;

import java.util.ArrayList;
import java.util.List;

import static main.com.company.service.InventoryService.compareItems;
import static main.com.company.service.InventoryService.createItem;

public class ShopController {

    public static Inventory shopping(Player player) {
        List<Item> items = new ArrayList<>(200);
        Inventory shopInventory = new Inventory(200, 200, items);
        for (int i = 0; i < 100; i++) {
            Item newItem = createItem();
            if (compareItems(shopInventory.getItems(), newItem)){
                String name = newItem.getName();
                items.stream().filter(z -> z.getName().equals(name)).forEach( x -> x.setQuantity(x.getQuantity()+1));
            }
            else items.add(newItem);
            newItem.setQuantity(1);
            shopInventory.setItems(items);
            shopInventory.setCapacity(shopInventory.getCapacity() - 1);
        }
        return shopInventory;
    }
}
